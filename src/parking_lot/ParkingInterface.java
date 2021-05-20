package parking_lot;

public interface ParkingInterface {

	void getStatusOfParkingLot();

	void processCreateParkingLot(Integer noOfSlots);

	void processGetParkingSlot(String cmdArray);

	void leaveParkingLot(String cmdArray, int i);

}
