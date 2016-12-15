package com.nuvizz.busticket.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "bus_service")
public class ServiceDTO implements Serializable {

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceDTO.class);

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ser_id")
	private int id;
	@Column(name = "Bus_name", unique = true)
	private String busName;
	@Column(name = "Reg_num", unique = true)
	private int regNo;
	@Column(name = "Driver_name")
	private String driverName;
	@Column(name = "Contact_num", unique = true)
	private String contactNo;
	@Column(name = "source")
	private String source;
	@Column(name = "Destination")
	private String destination;
	@Column(name = "Arrival_time")
	private String arrival;
	@Column(name = "Departure_time")
	private String departure;
	@Column(name = "seats")
	private int seat;
	@Column(name = "departure_date")
	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(style = "M-")
	private Date ddate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "p_id", nullable = false)
	private ProviderDTO providerDTO;

	public ServiceDTO() {
		logger.info(this.getClass().getSimpleName() + " Created!!!");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public ProviderDTO getProviderDTO() {
		return providerDTO;
	}

	public void setProviderDTO(ProviderDTO providerDTO) {
		this.providerDTO = providerDTO;
	}

	public Date getDdate() {
		return ddate;
	}

	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}

	@Override
	public String toString() {
		return "ServiceDTO [id=" + id + ", busName=" + busName + ", regNo="
				+ regNo + ", driverName=" + driverName + ", contactNo="
				+ contactNo + ", source=" + source + ", destination="
				+ destination + ", arrival=" + arrival + ", departure="
				+ departure + "]";
	}

}
