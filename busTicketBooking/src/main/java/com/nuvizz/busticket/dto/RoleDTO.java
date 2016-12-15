package com.nuvizz.busticket.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nuvizz.busticket.dao.registration.RegisterDAOImpl;

@Entity
@Table(name = "role_table")
public class RoleDTO implements Serializable {
	

	private static final Logger logger = LoggerFactory
			.getLogger(RoleDTO.class);

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "r_id")
	private int rid;
	@Column(name = "role",unique=true)
	private String role;
	
	@ManyToMany(fetch=FetchType.EAGER,mappedBy="rdtos")
	private Collection<UserDTO> dtos;

	public RoleDTO() {
		logger.info(this.getClass().getSimpleName() + " Created!!!");
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	public Collection<UserDTO> getDtos() {
		return dtos;
	}

	public void setDtos(Collection<UserDTO> dtos) {
		this.dtos = dtos;
	}

	@Override
	public String toString() {
		return "RoleDTO [rid=" + rid + ", role=" + role + "]";
	}
	
	

}
