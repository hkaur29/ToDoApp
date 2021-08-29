package com.javaproject.springboot.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.equals("test")) {
			return new User("test", "$2a$04$PAfiek78CO4s/cC/mpSbEuwsFTM4U7Q8swcTWkkxG0I/pmd5uHQKq", new ArrayList<>());
			// return new User("foo",
			// "$2a$12$h6xhYlySpMgr59jTLn9Su.bPwX23VxBEkDTHVBD41gRxZN27nKobm", new
			// ArrayList<>());
		} else {
			throw new UsernameNotFoundException("user is not found");
		}
	}

}
