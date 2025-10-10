package com.encora.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="`user`")
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long id;
	 String username;
	 String password;
	 public Long getId() {
		return id;
	}
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public String getUsername() {
		 return username;
	 }
	 public void setUsername(String username) {
		 this.username = username;
	 }
	 public String getPassword() {
		 return password;
	 }
	 public void setPassword(String password) {
		 this.password = password;
	 }
	 public String getRole() {
		 return role;
	 }
	 public void setRole(String role) {
		 this.role = role;
	 }
	 String role;
	 @Override
	 public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(role));
	 }
}
