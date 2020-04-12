package logic;

import entites.CargoAirplane;
import entites.Engine;
import entites.PassengerPlane;
import entites.Plane;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class PlaneFabric {
    static Plane createPlane(String s) {
        StringTokenizer stt = new StringTokenizer(s, " ");
        List<String> eachLine = new ArrayList<>();
        while (stt.hasMoreTokens()) {
            eachLine.add(stt.nextToken());
        }
        if (eachLine.get(0).equals("Pas")) {
            return new PassengerPlane(
                    Double.parseDouble(eachLine.get(1)),
                    Integer.parseInt(eachLine.get(2)),
                    Engine.valueOf(eachLine.get(3)),
                    Integer.parseInt(eachLine.get(4)),
                    eachLine.get(5),
                    Integer.parseInt(eachLine.get(6)),
                    Integer.parseInt(eachLine.get(7)),
                    Integer.parseInt(eachLine.get(8)));
        } else {
            return new CargoAirplane(
                    Double.parseDouble(eachLine.get(1)),
                    Integer.parseInt(eachLine.get(2)),
                    Engine.valueOf(eachLine.get(3)),
                    Integer.parseInt(eachLine.get(4)),
                    eachLine.get(5),
                    Integer.parseInt(eachLine.get(6)),
                    Double.parseDouble(eachLine.get(7)),
                    Double.parseDouble(eachLine.get(8)));
        }
    }
}
