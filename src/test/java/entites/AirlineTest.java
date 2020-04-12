package entites;

import logic.TxtFileReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirlineTest {
    private static Airline airline;

    @BeforeAll
    public static void createAirline(){
       File file = new File("src\\main\\resources\\Planes");
        HashSet<Plane> planes1 = TxtFileReader.getPlanesFromFile(file);
        airline = new Airline(planes1);
        System.out.println(airline.toString() + "qq");
    }

    @Test
    public void findAllPassengers() {
        assertEquals(444, airline.findAllPassengers());
    }

    @Test
    public void findAllCarryingCapacity() {
        assertEquals(341990, airline.findAllCarryingCapacity());
    }

    @Test
    public void findPlaneWithRequiredFuelConsumption() {
        Plane plane = new CargoAirplane(15.9, 15400, Engine.D_18T, 6, "EW-10888", 250000, 4.5, 4.0);
        assertEquals(plane, airline.findPlaneWithRequiredFuelConsumption(12.,16.));
    }
}