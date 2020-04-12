package entites;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaneRangeAndCarryCapacityComparatorTest {

    @Test
    public void compare() {
        Plane plane1 = new CargoAirplane(10.4, 5250, Engine.AE2100D3, 4, "EW-10360", 18950, 3.0, 2.7);
        Plane plane2 = new PassengerPlane(2.5, 5400, Engine.CFM56, 2, "EW-100AA", 20540, 144, 16);
        assertEquals(-1, new PlaneRangeAndCarryCapacityComparator().compare(plane1, plane2));
    }
}