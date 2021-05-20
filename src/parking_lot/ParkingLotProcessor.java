package parking_lot;

import com.parkinglot.enums.CommandsEnum;

public class ParkingLotProcessor implements ParkingInterface {

	@Override
	public void processCreateParkingLot(Integer noOfSlots) {

	}

	@Override
	public void processGetParkingSlot(String cmdArray) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getStatusOfParkingLot() {

	}

	@Override
	public void leaveParkingLot(String cmdArray, int i) {

	}

	public void processCommand(String command) {
		String[] cmdArray = command.split(" ");
		CommandsEnum cmd = CommandsEnum.valueOf(cmdArray[0]);
		switch (cmd) {
		case create_parking_lot:
			processCreateParkingLot(Integer.parseInt(cmdArray[1]));
			break;

		case leave:
			leaveParkingLot(cmdArray[1], Integer.parseInt(cmdArray[2]));
			break;
		case park:
			processGetParkingSlot(cmdArray[1]);
			break;
		case status:
			getStatusOfParkingLot();
			break;
		default:

			break;
		}

		switch (cmd) {
		case create_parking_lot: {

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + cmd);
		}

	}

}
