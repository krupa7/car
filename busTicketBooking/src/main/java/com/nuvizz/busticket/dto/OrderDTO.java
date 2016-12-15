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

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "order_table")
public class OrderDTO implements Serializable {

	private static final Logger logger = LoggerFactory
			.getLogger(OrderDTO.class);

	@Id
/*	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")*/
	@Column(name = "o_id")
	private int oid;
	@Column(name = "username")
	private String username;
	@Column(name = "bus_name")
	private String busname;
	@Column(name = "source")
	private String source;
	@Column(name = "destination")
	private String destination;
	@Column(name = "booking_date")
	private Date bookdate;
	@Column(name = "tickets")
	private int ticket;

	public OrderDTO() {
		logger.info(this.getClass().getSimpleName() + " created!!");
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBusname() {
		return busname;
	}

	public void setBusname(String busname) {
		this.busname = busname;
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

	public Date getBookdate() {
		return bookdate;
	}

	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "OrderDTO [oid=" + oid + ", username=" + username + ", busname="
				+ busname + ", source=" + source + ", destination="
				+ destination + ", bookdate=" + bookdate + ", ticket=" + ticket
				+ "]";
	}

}
