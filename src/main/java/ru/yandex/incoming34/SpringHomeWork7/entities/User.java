package ru.yandex.incoming34.SpringHomeWork7.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
@Table (name = "users")
public class User {
	
	@Id
	Long id;
	
	private String userName;
	private String password;
	
	
	@ManyToMany
	@JoinTable(name = "user_role", 
	joinColumns = { @JoinColumn(name = "user_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roleSet;
	
	public User(String userName, String password, Set<Role> set) {
		this.userName = userName;
		this.password = password;
		roleSet =  set;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<String> getAuthorities(){
		return null;
				//authorityList;
	}
	public Set<Role> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}
	public Set<Role> getAuthoritySet() {
		return roleSet;
	}
	public void setAuthoritySet(Set<Role> authoritySet) {
		this.roleSet = authoritySet;
	}
	
	
	

}
