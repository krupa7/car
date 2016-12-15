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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "country")
@JsonIgnoreProperties(ignoreUnknown=true,value={"dtos"})
public class CountryDTO implements Serializable {


	private static final Logger logger = LoggerFactory
			.getLogger(CountryDTO.class);
	
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "c_id")
	private int cid;
	@Column(unique=true)
	private String country;

	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "c_id")
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dto",cascade=CascadeType.ALL)
	private Collection<StateDTO> dtos;

	public CountryDTO() {
		logger.info(this.getClass().getSimpleName() + " Created!!!");
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Collection<StateDTO> getDtos() {
		return dtos;
	}

	public void setDtos(Collection<StateDTO> dtos) {
		this.dtos = dtos;
	}

	@Override
	public String toString() {
		return "CountryDTO [cid=" + cid + ", country=" + country + "]";
	}

}
