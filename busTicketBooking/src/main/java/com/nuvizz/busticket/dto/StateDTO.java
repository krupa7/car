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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nuvizz.busticket.dao.registration.RegisterDAOImpl;

@Entity
@Table(name = "state")
@JsonIgnoreProperties(ignoreUnknown=true,value={"dto","dtos"})
public class StateDTO implements Serializable {

	private static final Logger logger = LoggerFactory
			.getLogger(StateDTO.class);

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "s_id")
	private int sid;
	@Column(name = "state")
	private String state;

	//@ManyToOne(cascade = CascadeType.ALL)
	//private CountryDTO dto;

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "c_id", nullable = false)
	private CountryDTO dto;

	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "s_id")
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sdto",cascade=CascadeType.ALL)
	private Collection<CityDTO> dtos;

	public StateDTO() {
		logger.info(this.getClass().getSimpleName() + " Created!!!");
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public CountryDTO getDto() {
		return dto;
	}

	public void setDto(CountryDTO dto) {
		this.dto = dto;
	}

	public Collection<CityDTO> getDtos() {
		return dtos;
	}

	public void setDtos(Collection<CityDTO> dtos) {
		this.dtos = dtos;
	}

	@Override
	public String toString() {
		return "stateDTO [sid=" + sid + ", state=" + state + ", dto=" + dto
				+ "]";
	}

}
