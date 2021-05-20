package com.parkinglot.utils;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.TreeMap;

import com.parkinglot.pojos.Slot;

public class ParkingUtils {
	public static Map<Integer, Slot> slotToSlotObjMapping = new TreeMap<Integer, Slot>();
	
	public static long noOfHoursBetweenTwoDates(LocalTime localTime, LocalTime localTime2) {
		long hours = ChronoUnit.HOURS.between(localTime, localTime2);
		long minutes = localTime.until(localTime2, ChronoUnit.MINUTES);
		if (minutes > 0)
			hours++;
		return hours;
	}
	
	public static void main(String[] args) {
		System.out.println(noOfHoursBetweenTwoDates(LocalTime.of(3, 10), LocalTime.of(4, 30)));
	}
}
