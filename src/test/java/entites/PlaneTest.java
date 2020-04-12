package entites;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlaneTest {

    @Test
    public void testEquals() {
        Plane plane1 = new CargoAirplane(10.4,5250, Engine.AE2100D3, 4, "EW-10360", 18950, 3.0, 2.7);
        Plane plane2 = new CargoAirplane(10.4, 5250, Engine.AE2100D3, 4, "EW-10300", 18950, 3.0, 2.7);
        assertNotEquals(plane1, plane2);
    }
}