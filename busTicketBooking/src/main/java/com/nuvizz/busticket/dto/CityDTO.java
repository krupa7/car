package com.nuvizz.busticket.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "city")
public class CityDTO implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(CityDTO.class);

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "city_id")
	private int id;
	@Column(name = "city",unique=true)
	private String city;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "s_id", nullable = false)
	private StateDTO sdto;

	public CityDTO() {
		logger.info(this.getClass().getSimpleName() + " Created!!!");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public StateDTO getSdto() {
		return sdto;
	}

	public void setSdto(StateDTO sdto) {
		this.sdto = sdto;
	}

	@Override
	public String toString() {
		return "CityDTO [id=" + id + ", city=" + city + ", sdto=" + sdto + "]";
	}

}
