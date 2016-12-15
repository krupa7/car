package com.nuvizz.car.dto.login;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="login")
public class LoginDTO implements Serializable {

	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	@Column(name="id")
	private int id;
	@Column(name="u_id")
	private String uid;
	@Column(name="password")
	private String password;

	public LoginDTO() {
		System.out.println(this.getClass().getSimpleName() + " Created !!");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", uid=" + uid + ", password=" + password
				+ "]";
	}
	
	
}
