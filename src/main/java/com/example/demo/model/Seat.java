package com.example.demo.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Seat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seatId;
	private char seatNo;
	
	public Seat() {}
	public char getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(char seatNo) {
		this.seatNo = seatNo;
	}
	
}
