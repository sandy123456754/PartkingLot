package com.parkinglot.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parking_lot.ParkingLotProcessor;

public class ParkingLotTest {

	private ParkingLotProcessor parkingLotProcessor;
	
	@BeforeEach                                         
    public void setUp() throws Exception {
		parkingLotProcessor = new ParkingLotProcessor();
		parkingLotProcessor.processCreateParkingLot(4);
    }
	
	@Test                                               
    public void testAllocationSlotParking() {
        assertEquals("Allocated slot number: 1",parkingLotProcessor.processGetParkingSlot("AP123456"));          
    }
	
	@Test
	public void testNoParkingSlot() {
		assertEquals("Allocated slot number: 1",parkingLotProcessor.processGetParkingSlot("AP123457"));
		assertEquals("Allocated slot number: 2",parkingLotProcessor.processGetParkingSlot("AP123458"));
		assertEquals("Allocated slot number: 3",parkingLotProcessor.processGetParkingSlot("AP123459"));
		assertEquals("Allocated slot number: 4",parkingLotProcessor.processGetParkingSlot("AP123450"));
		assertEquals("Sorry, parking lot is full",parkingLotProcessor.processGetParkingSlot("AP123456"));
	}
	
	@Test
	public void testLeaveParkingLot() {
		assertEquals("Allocated slot number: 1",parkingLotProcessor.processGetParkingSlot("AP123457"));
		assertEquals("Allocated slot number: 2",parkingLotProcessor.processGetParkingSlot("AP123458"));
		assertEquals("Allocated slot number: 3",parkingLotProcessor.processGetParkingSlot("AP123459"));
		assertEquals("Registration number " + "AP123458" + " with Slot Number " + 2
				+ " is free with Charge " + 10, parkingLotProcessor.leaveParkingLot("AP123458", 2));
		assertEquals("Allocated slot number: 2",parkingLotProcessor.processGetParkingSlot("AP123460"));
	}
	
	@Test
	public void testLeaveParkingLot2() {
		assertEquals("Allocated slot number: 1",parkingLotProcessor.processGetParkingSlot("AP123457"));
		assertEquals("Allocated slot number: 2",parkingLotProcessor.processGetParkingSlot("AP123458"));
		assertEquals("Allocated slot number: 3",parkingLotProcessor.processGetParkingSlot("AP123459"));
		assertEquals("Registration number " + "AP123458" + " with Slot Number " + 2
				+ " is free with Charge " + 10, parkingLotProcessor.leaveParkingLot("AP123458", 2));
		assertNotEquals("Allocated slot number: 1",parkingLotProcessor.processGetParkingSlot("AP123460"));
	}
	
	@Test
	public void testCheckNearestParkingSlot() {
		assertEquals("Allocated slot number: 1",parkingLotProcessor.processGetParkingSlot("AP123456"));
		assertEquals("Allocated slot number: 2",parkingLotProcessor.processGetParkingSlot("AP123457"));
		assertEquals("Allocated slot number: 3",parkingLotProcessor.processGetParkingSlot("AP123458"));
		assertEquals("Allocated slot number: 4",parkingLotProcessor.processGetParkingSlot("AP123459"));
		assertEquals("Registration number " + "AP123457" + " with Slot Number " + 2
				+ " is free with Charge " + 10, parkingLotProcessor.leaveParkingLot("AP123457", 2));
		assertEquals("Registration number " + "AP123459" + " with Slot Number " + 4
				+ " is free with Charge " + 10, parkingLotProcessor.leaveParkingLot("AP123459", 4));
		assertEquals("Allocated slot number: 2",parkingLotProcessor.processGetParkingSlot("AP123460"));
	}
	
	
	
	
}
