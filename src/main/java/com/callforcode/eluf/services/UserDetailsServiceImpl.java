package com.callforcode.eluf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.repositories.ClientRepository;
import com.callforcode.eluf.security.UserSS;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClientRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		Client cli = repo.findByMail(mail);
		if(mail == null) {
			throw new UsernameNotFoundException(mail); 
		}
		
		return new UserSS(cli.getId(), cli.getMail(), cli.getPassword(), cli.getProfiles());
	}

}

