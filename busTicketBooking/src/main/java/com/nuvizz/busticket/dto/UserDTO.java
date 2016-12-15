package com.nuvizz.busticket.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nuvizz.busticket.dao.registration.RegisterDAOImpl;

@Entity
@Table(name = "registration")
public class UserDTO implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(UserDTO.class);

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "u_id")
	private int id;
	@Column(name = "u_name")
	private String username;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "password")
	private String password;
	private String cpass;
	@Column(name = "email")
	private String email;
	@Column(name = "phoneNo")
	private long phoneNo;
	@Column(name = "country")
	private String country;
	@Column(name = "state")
	private String state;
	@Column(name = "city")
	private String city;
	@Column(name = "address1")
	private String address1;
	@Column(name = "address2")
	private String address2;

	@ManyToMany()
	@JoinTable(name = "USER_ROLE_TABLE", joinColumns = { @JoinColumn(name = "u_id", updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "r_id", updatable = false) })
	private Collection<RoleDTO> rdtos;

	public UserDTO() {
		logger.info(this.getClass().getSimpleName() + " Created!!!");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	

	public Collection<RoleDTO> getRdtos() {
		return rdtos;
	}

	public void setRdtos(Collection<RoleDTO> rdtos) {
		this.rdtos = rdtos;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", lastname="
				+ lastname + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", country=" + country + ", state=" + state + ", city="
				+ city + ", address1=" + address1 + ", address2=" + address2
				+ "]";
	}

}
