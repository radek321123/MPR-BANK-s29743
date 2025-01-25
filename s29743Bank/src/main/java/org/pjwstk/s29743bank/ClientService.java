package org.pjwstk.s29743bank;

import org.springframework.stereotype.Component;

@Component
public class ClientService {

    private ClientStorage clientStorage;

    public ClientService(ClientStorage clientStorage) {
    }



    //REJESTRACJA KLIENTA
    void addClient(int id, double money){
        clientStorage.addClient(id, money);
    }




    //PRZELEW
    TransferStatus transfer(int id, double amount) throws Exception {
        Client client = clientStorage.getClient(id);
        if(client == null){
            throw new Exception("Cant find client");
        }

        if (client.getMoney() >= amount){
            client.setMoney(client.getMoney()-amount);
            return new TransferStatus(Status.ACCEPTED, client.getMoney());
        }
        return new TransferStatus(Status.DECLINED, client.getMoney());
    }




    //WPŁATA NA KONTO
    TransferStatus deposit(int id, double amount) throws Exception {
        Client client = clientStorage.getClient(id);
        if(client == null){
            throw new Exception("Cant find client");
        }

        client.setMoney(client.getMoney()+amount);

        return new TransferStatus(Status.ACCEPTED, client.getMoney());
    }




    //ODCZYTANIE DANYCH KLIENTA
    Client getClient(int id) throws Exception {
        Client client = clientStorage.getClient(id);

        if (client == null) throw new Exception("Cant find client");
        return client;
    }
}
