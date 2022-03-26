package ru.yandex.incoming34.SpringHomeWork7.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.yandex.incoming34.SpringHomeWork7.entities.Role;
import ru.yandex.incoming34.SpringHomeWork7.entities.User;
import ru.yandex.incoming34.SpringHomeWork7.repos.UserRepo;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findOneByUsername(username);
		if (user != null) {
			return (UserDetails) new User(user.getUserName(), user.getPassword(), buildSimpleGrantedAuthorities(user.getRoles()));
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
 
    private static Set<Role> buildSimpleGrantedAuthorities(final Set<Role> roles) {
        /*
    	Set<Role> roleSet = new HashSet<>();
        for (Role role : roles) {
            roleSet.add(new SimpleGrantedAuthority(role.getName()));
        }
        */
        return roles;
    }	
    
    

}
