package logic;

import entites.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PlaneValidator {
    private static String serialNumberPattern = "EW-\\d{3}.{2}";

    static void checkValues(String line)
            throws IndexOutOfBoundsException, IllegalArgumentException {
        StringTokenizer stt = new StringTokenizer(line, " ");
        List<String> eachLine = new ArrayList<String>();
        while (stt.hasMoreTokens()) {
            eachLine.add(stt.nextToken());
        }
        if (isCorrectPlaneValues(Double.parseDouble(eachLine.get(1)),
                Integer.parseInt(eachLine.get(2)),
                eachLine.get(3),
                Integer.parseInt(eachLine.get(4)),
                eachLine.get(5),
                Integer.parseInt(eachLine.get(6)))) {
            switch (eachLine.get(0)) {
                case "Pas":
                    if (isCorrectNumberOfBusinessSeats(Integer.parseInt(eachLine.get(7)))
                            && isCorrectNumberOfEconomySeats(Integer.parseInt(eachLine.get(8)))) {
                        return;
                    }
                case "Car":
                    if (isCorrectHatchWidth(Double.parseDouble(eachLine.get(7)))
                            && isCorrectHatchHeight(Double.parseDouble(eachLine.get(8)))) {
                        return;
                    }
            }
        }
        throw new IllegalArgumentException("Incorrect data entry");
    }

    private static boolean isCorrectPlaneValues(double fuelConsumer, int rangeOfFlight, String engineType,
                                                int numberOfEngines, String serialNumber, int carryingCapacity) {
        return isCorrectFuelConsumption(fuelConsumer)
                && isCorrectRangeOfFlight(rangeOfFlight)
                && isCorrectEngineType(engineType)
                && isCorrectNumberOfEngines(numberOfEngines)
                && isCorrectSerialNumber(serialNumber)
                && isCorrectCarryingCapacity(carryingCapacity);
    }

    private static boolean isCorrectFuelConsumption(double fuelConsumption) {
        return fuelConsumption > 0;
    }

    private static boolean isCorrectRangeOfFlight(int rangeOfFlight) {
        return rangeOfFlight > 1000;
    }

    private static boolean isCorrectNumberOfEngines(int numberOfEngines) {
        return numberOfEngines > 0 && numberOfEngines < 10;
    }

    private static boolean isCorrectEngineType(String engineType) {
        Engine.valueOf(engineType);
        return true;
    }

    private static boolean isCorrectSerialNumber(String serialNumber) {
        Pattern pattern = Pattern.compile(serialNumberPattern);
        Matcher matcher = pattern.matcher(serialNumber);
        return matcher.matches();
    }

    private static boolean isCorrectCarryingCapacity(int carryingCapacity) {
        return carryingCapacity > 1000;
    }

    private static boolean isCorrectNumberOfEconomySeats(int numberOfEconomySeats) {
        return numberOfEconomySeats > 0;
    }

    private static boolean isCorrectNumberOfBusinessSeats(int numberOfBusinessSeats) {
        return numberOfBusinessSeats > -1;
    }

    private static boolean isCorrectHatchWidth(double hatchWidth) {
        return hatchWidth > 0;
    }

    private static boolean isCorrectHatchHeight(double hatchHeight) {
        return hatchHeight > 0;
    }
}
