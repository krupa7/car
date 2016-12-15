package com.nuvizz.busticket.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "provider")
public class ProviderDTO implements Serializable {

	private static final Logger logger = LoggerFactory
			.getLogger(ProviderDTO.class);

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "p_id")
	private int pid;
	@Column(name = "provider_name",unique=true)
	private String pname;
	@Column(name = "description")
	private String description;
	@Column(name = "contact_num",unique=true)
	private long contactNo;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "providerDTO")
	private Collection<ServiceDTO> serviceDTOs	;

	public ProviderDTO() {
		logger.info(this.getClass().getSimpleName() + " Created!!!");
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public Collection<ServiceDTO> getServiceDTOs() {
		return serviceDTOs;
	}

	public void setServiceDTOs(Collection<ServiceDTO> serviceDTOs) {
		this.serviceDTOs = serviceDTOs;
	}

	@Override
	public String toString() {
		return "providerDTO [pid=" + pid + ", pname=" + pname
				+ ", description=" + description + ", contactNo=" + contactNo
				+ "]";
	}

}
