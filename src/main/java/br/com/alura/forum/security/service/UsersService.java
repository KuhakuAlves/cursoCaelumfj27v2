package br.com.alura.forum.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.forum.model.User;
import br.com.alura.forum.repository.UserRepository;

@Service
public class UsersService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		
		return user.orElseThrow(() -> new UsernameNotFoundException("Não foi possível " + "encontrar usuario com email: " + email));
	}

	public UserDetails loadUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return user.orElseThrow(() -> new UsernameNotFoundException("Não foi possível " + "encontrar usuario com id: " + userId));
	}

}
