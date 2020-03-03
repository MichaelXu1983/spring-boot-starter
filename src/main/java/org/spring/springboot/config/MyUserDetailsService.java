package org.spring.springboot.config;

import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username-password
		System.out.println("ok");

		// User user = new User(username, "123456",
		// AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		// 返回员工信息
		com.user.model.User user = userService.findUserByName(username); 

		return new User(user.getUserName(), user.getPsd(),
				AuthorityUtils.commaSeparatedStringToAuthorityList(username));
	}

}
