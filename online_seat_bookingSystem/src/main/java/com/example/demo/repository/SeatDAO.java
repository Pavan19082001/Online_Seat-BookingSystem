package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Seat;

@Repository
public interface SeatDAO extends JpaRepository<Seat, Integer>{

}
