package abecedario.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import abecedario.domain.repository.GestorRepository;
@Service
public class GestorService  implements UserDetailsService{
	@Autowired
	private GestorRepository gesRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return gesRepo.findByEmail(username);
	}
}
