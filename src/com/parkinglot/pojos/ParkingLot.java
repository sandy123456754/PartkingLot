package com.parkinglot.pojos;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	public List<Slot> slots = null;
	public Integer capacity; 
	
	public ParkingLot(Integer capacity) {
		slots = new ArrayList<Slot>(capacity);
		this.capacity = capacity;
		for(int i=1; i < capacity+1; i++) {
			Slot slot = new Slot(i, true);
			slots.add(slot);
		}
	}
}
