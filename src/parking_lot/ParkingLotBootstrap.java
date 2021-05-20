package parking_lot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotBootstrap {
	public static void main(String[] args) throws FileNotFoundException {
		try (BufferedReader br = new BufferedReader(new FileReader("/input/file_input.txt"));) {

			List<String> listOfCommands = br.lines().collect(Collectors.toList());
			ParkingLotProcessor parkingLotProcessor = new ParkingLotProcessor();
			for (String command : listOfCommands) {
				parkingLotProcessor.processCommand(command);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
