package com.nuvizz.car.dto.carservice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="service_car")
public class CarServiceDTO implements Serializable{
	
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private int id;
	@Column(name = "owner")
	private String owner;
	@Column(name = "vehicle_no")
	private String vehicleNo;
	@Column(name = "chasis_no")
	private String chasisNo;
	@Column(name = "manufacturer")
	private String manufacturer;
	@Column(name = "model")
	private String model;
	@Column(name = "comment")
	private String comment;
	@Column(name = "Date")
	private Date date;
	
	public CarServiceDTO() {
		System.out.println(this.getClass().getSimpleName() + " Created !!");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getChasisNo() {
		return chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CarServiceDTO [id=" + id + ", owner=" + owner + ", vehicleNo="
				+ vehicleNo + ", chasisNo=" + chasisNo + ", manufacturer="
				+ manufacturer + ", model=" + model + ", comment=" + comment
				+ ", date=" + date + "]";
	}
	
	

}
