package com.callforcode.eluf.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.repositories.ClientRepository;
import com.callforcode.eluf.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private MailService mailService;

	private Random rand = new Random();

	public void sendNewPassword(String mail) {

		Client client = clientRepository.findByMail(mail);
		if (client == null) {
			throw new ObjectNotFoundException("Mail não encontrado");
		}
		String newPass = newPassWord();
		client.setPassword(pe.encode(newPass));

		clientRepository.save(client);
		mailService.sendNewPasswordMail(client, newPass);

	}

	private String newPassWord() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);

	}

	private char randomChar() {
		int opt = rand.nextInt(3);

		if (opt == 0) { // Gera um digito

			return (char) (rand.nextInt(10) + 48);

		} else if (opt == 1) { // Gera letra maiuscula

			return (char) (rand.nextInt(26) + 65);

		} else { // Gera letra minuscula

			return (char) (rand.nextInt(26) + 97);
		}

	}

}
