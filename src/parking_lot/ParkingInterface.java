package parking_lot;

import com.parkinglot.pojos.ParkingLot;

public interface ParkingInterface {

	void getStatusOfParkingLot();

	Integer processCreateParkingLot(Integer noOfSlots);

	String processGetParkingSlot(String cmdArray);

	String leaveParkingLot(String cmdArray, int i);

}
