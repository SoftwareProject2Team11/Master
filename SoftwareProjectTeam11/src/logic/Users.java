package logic;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="remember_token")
	private String remember_token;
	@Column(name="created_at")
	private LocalDate created_at;
	@Column(name="updated_at")
	private LocalDate updated_at;
	@Column(name="manager")
	private int manager;
	
	
	
	

}
