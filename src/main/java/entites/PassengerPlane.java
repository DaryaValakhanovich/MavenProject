package entites;

public class PassengerPlane extends Plane {
    private int numberOfEconomySeats;
    private int numberOfBusinessSeats;

    public PassengerPlane(double fuelConsumption, int rangeOfFlight, Engine engineType,
                          int numberOfEngines, String serialNumber, int carryingCapacity,
                          int numberOfEconomySeats, int numberOfBusinessSeats) {
        super(fuelConsumption, rangeOfFlight, engineType, numberOfEngines, serialNumber, carryingCapacity);
        this.numberOfEconomySeats = numberOfEconomySeats;
        this.numberOfBusinessSeats = numberOfBusinessSeats;
    }

    int getNumberOfEconomySeats() {
        return numberOfEconomySeats;
    }

    int getNumberOfBusinessSeats() {
        return numberOfBusinessSeats;
    }

    @Override
    public String toString() {
        return "PassengerPlane{" + super.toString() +
                "numberOfEconomySeats=" + numberOfEconomySeats +
                ", numberOfBusinessSeats=" + numberOfBusinessSeats +
                "} ";
    }
}
