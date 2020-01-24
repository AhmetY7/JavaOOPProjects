package spacechallenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulation {
    public ArrayList<Item> loadItems(String file) throws FileNotFoundException {
        ArrayList<Item> data = new ArrayList<>();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((dataRow = br.readLine()) != null) {
                String[] dataRecords = dataRow.split("=");
                data.add(new Item(dataRecords[0],Double.parseDouble(dataRecords[1])));
            }

        } catch (IOException e) {
            System.out.println("Could not find file");
            e.printStackTrace();
        }
        return data;
    }
    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> u1Rockets = new ArrayList<>();
        Rocket u1Rocket = new U1();
        boolean isAdded = false;
        for(Item item : items) {
            if(u1Rocket.canCarry(item)) {
                u1Rocket.carry(item);
                isAdded = false;
            } else {
                u1Rockets.add(u1Rocket);
                u1Rocket = new U1();
                u1Rocket.carry(item);
                isAdded = true;
            }
        }
        if(!isAdded) {
            u1Rockets.add(u1Rocket);
        }
        return u1Rockets;
    }
    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> u2Rockets = new ArrayList<>();
        Rocket u2Rocket = new U2();
        boolean isAdded = false;
        for (Item item : items) {
            if(u2Rocket.canCarry(item)) {
                u2Rocket.carry(item);
                isAdded = false;
            } else {
                u2Rockets.add(u2Rocket);
                u2Rocket = new U2();
                u2Rocket.carry(item);
                isAdded = true;
            }
        }
        if(!isAdded) {
            u2Rockets.add(u2Rocket);
        }
        return u2Rockets;
    }
    public double runSimulation(ArrayList<Rocket> rockets) {
        double totalCost = 0.0;
        for(Rocket rocket : rockets) {
            while (!rocket.land() || !rocket.launch()) {
                totalCost += rocket.rocketCost;
            }
            totalCost += rocket.rocketCost;
        }
        return totalCost;
    }
}
