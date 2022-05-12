package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OfficeDetails {
	@Id
	private String name;
	private int floorNo;
	private int roomNo;
	public OfficeDetails() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

}
