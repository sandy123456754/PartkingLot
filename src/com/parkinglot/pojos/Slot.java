package com.parkinglot.pojos;

import java.time.LocalTime;

public class Slot {

	private String car_number;
	private Integer allocated_slot;
	private Boolean isVacant;
	private LocalTime checkInTime;
	
	public Slot(Integer slot, Boolean vacant) {
		this.allocated_slot = slot;
		this.isVacant = vacant;
	}

	public LocalTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCar_number() {
		return car_number;
	}

	public Boolean getVacant() {
		return isVacant;
	}

	public void setVacant(Boolean vacant) {
		this.isVacant = vacant;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public Integer getAllocated_slot() {
		return allocated_slot;
	}

	public void setAllocated_slot(Integer allocated_slot) {
		this.allocated_slot = allocated_slot;
	}

	@Override
	public String toString() {
		return "Slot [car_number=" + car_number + ", allocated_slot=" + allocated_slot + "]";
	}
	
	public void reset() {
		car_number = null;
		isVacant = true;
		checkInTime = null;
	}

}
