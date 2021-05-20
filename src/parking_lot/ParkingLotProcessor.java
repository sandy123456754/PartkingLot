package parking_lot;

import java.time.LocalTime;
import java.util.Map.Entry;

import com.parkinglot.enums.CommandsEnum;
import com.parkinglot.pojos.ParkingLot;
import com.parkinglot.pojos.Slot;
import com.parkinglot.utils.ParkingUtils;

public class ParkingLotProcessor implements ParkingInterface {

	ParkingLot parkingLot = null;

	@Override
	public void processCreateParkingLot(Integer noOfSlots) {
		this.parkingLot = new ParkingLot(noOfSlots);
	}

	@Override
	public void processGetParkingSlot(String car_number) {
		if (parkingLot != null) {
			Slot allotedSlot = null;
			for (Slot slot : parkingLot.slots) {
				if (slot.getVacant()) {
					slot.setCar_number(car_number);
					slot.setCheckInTime(LocalTime.now());
					slot.setVacant(false);
					allotedSlot = slot;
					ParkingUtils.slotToSlotObjMapping.put(slot.getAllocated_slot(), slot);
					break;
				}
			}
			if (allotedSlot != null) {
				ParkingUtils.slotToSlotObjMapping.put(allotedSlot.getAllocated_slot(), allotedSlot);
				System.out.println("Allocated slot number: " + allotedSlot.getAllocated_slot());

			} else {
				System.out.println("Sorry, parking lot is full");
			}
		} else {
			System.out.println("There is no parking lot");
		}
	}

	@Override
	public void getStatusOfParkingLot() {
		System.out.println("Slot No." + "       " + "Registration No.");
		for (Entry<Integer, Slot> entry : ParkingUtils.slotToSlotObjMapping.entrySet()) {
			if (entry.getValue().getCar_number() != null)
				System.out.println(entry.getKey() + "              " + entry.getValue().getCar_number());
		}
	}

	@Override
	public void leaveParkingLot(String cmdArray, int i) {
		Slot slot = ParkingUtils.slotToSlotObjMapping.get(i);
		long hours = ParkingUtils.noOfHoursBetweenTwoDates(slot.getCheckInTime(), LocalTime.now());
		long charge = 10;
		if (hours > 2)
			charge = (hours - 2) * 10;
		System.out.println("Registration number " + slot.getCar_number() + " with Slot Number " + i
				+ " is free with Charge " + charge);
		slot.reset();
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
			System.out.println("No Existing Command Found");
			break;
		}

	}

}
