package com.ms.mongowheels.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ms.mongowheels.repositories.UserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	@Lazy
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		com.ms.mongowheels.beans.User user = userRepo.findUserAccount(username);
		
		if (user == null) {
			System.out.println("User not found "+ username);
			throw new UsernameNotFoundException("User " + username + " not found");
		}
	
		List<String> roles = userRepo.getRolesById(user.getUserId());
		System.out.println(roles);		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roles != null) {
			for(String role : roles ) {
				grantList.add(new SimpleGrantedAuthority(role));
			}		
		}
		
		User springUser = new User(user.getUserName(), user.getEncryptedPassword(), grantList);
		
		UserDetails userDetails = (UserDetails)springUser;
		return userDetails;
	}
}
