package org.pjwstk.s29743bank;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ClientStorage {
    ArrayList<Client> clients;

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    void addClient(int id, double money){
        clients.add(new Client(id, money));
    }

    Client getClient(int id){
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}
