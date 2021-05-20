package parking_lot;

public interface ParkingInterface {


	public void getStatusOfParkingLot();

	void processCreateParkingLot(Integer noOfSlots);

	void processGetParkingSlot(String cmdArray);

	void leaveParkingLot(String cmdArray, int i);

}
