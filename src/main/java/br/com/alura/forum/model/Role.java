package br.com.alura.forum.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	public static final Role ROLE_ADMIN = new Role("ROLE_ADMIN");
	public static final Role ROLE_ALUNO = new Role("ROLE_ALUNO");
	
	@Id
	private String authority;
	
	@Override
	public String getAuthority() {
		
		return this.authority;
	}
	
	@Deprecated
	public Role() {}
	
	public Role(String authority) {
		this.authority = authority;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role role = (Role) obj;
		return Objects.equals(authority, role.authority);
	}
	
	

}
