package org.pjwstk.s29743bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S29743BankApplication {

	public S29743BankApplication(ClientService clientService){
	}

	public static void main(String[] args) {
		SpringApplication.run(S29743BankApplication.class, args);
	}

}
