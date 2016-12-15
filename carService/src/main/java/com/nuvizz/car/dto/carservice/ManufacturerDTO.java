package com.nuvizz.car.dto.carservice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="manufacturer")
public class ManufacturerDTO implements Serializable {

	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	@Column(name="id")
	private int id;
	@Column(name="manufacturer")
	private String manufacturer;
	
	public ManufacturerDTO() {
		System.out.println(this.getClass().getSimpleName() + " Created !!");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "ManufacturerDTO [id=" + id + ", manufacturer=" + manufacturer
				+ "]";
	}
	
	
}
