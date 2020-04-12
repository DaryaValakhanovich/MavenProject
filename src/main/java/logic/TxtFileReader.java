package logic;

import entites.Plane;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TxtFileReader {
    private static final Logger log = Logger.getLogger(String.valueOf(TxtFileReader.class));

    private static List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            if (lines.isEmpty()) {
                throw new NullPointerException();
            }
        } catch (NullPointerException ex) {
            System.out.println("File is empty.");
            log.error("File is empty.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            log.error(ex.getMessage());
        }
        return lines;
    }

    public static HashSet<Plane> getPlanesFromFile(File file) {
        List<String> lines = readFile(file);
        HashSet<Plane> planes = new HashSet<>();
        for (String s : lines) {
            try {
                PlaneValidator.checkValues(s);
                planes.add(PlaneFabric.createPlane(s));
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Not enough parameters. " + ex.getMessage() + ". Line:\n" + s);
                log.error("Not enough parameters. " + ex.getMessage() + ".\nLine: " + s);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage() + ". Line:\n" + s);
                log.error(ex.getMessage() + ".\nLine: " + s);
            }
        }
        return planes;
    }

}
