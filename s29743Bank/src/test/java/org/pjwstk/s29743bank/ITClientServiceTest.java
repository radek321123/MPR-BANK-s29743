package org.pjwstk.s29743bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class ITClientServiceTest {
    @MockitoBean
    private ClientStorage clientStorage;

    //@Autowired
    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    void openMocks() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void ShouldGetClient() throws Exception {
        when(clientStorage.getClient(anyInt())).thenReturn(new Client(1, 1000.00));

        Client client = clientService.getClient(1);

        assertThat(client.getId()).isEqualTo(1);
        assertThat(client.getMoney()).isEqualTo(1000.00);
    }

    @Test
    void ShouldThrowException(){
        when(clientStorage.getClient(anyInt())).thenReturn(null);


        Exception exception = assertThrows(Exception.class, () -> {
            clientService.getClient(2);
        });

        assertThat(exception.getMessage()).isEqualTo("Cant find client");
    }

    @Test
    void ShouldAddMoney() throws Exception {
        when(clientStorage.getClient(anyInt())).thenReturn(new Client(1, 1000.00));

        Client client = clientService.getClient(3);

        clientService.deposit(1, 100.00);

        assertThat(client.getMoney()).isEqualTo(1100.00);
    }


    @Test
    void ShouldSubtractMoney() throws Exception {
        when(clientStorage.getClient(anyInt())).thenReturn(new Client(1, 1000.00));

        Client client = clientService.getClient(4);

        clientService.transfer(1, 100.00);

        assertThat(client.getMoney()).isEqualTo(900.00);
    }
}