package spacechallenge;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String phase1 = "C:\\Users\\ahmet\\Desktop\\Software\\Java\\JavaOOPProjects\\src\\spacechallenge\\phase-1.txt.txt";
        String phase2 = "C:\\Users\\ahmet\\Desktop\\Software\\Java\\JavaOOPProjects\\src\\spacechallenge\\phase-2.txt.txt";
        Simulation simulation = new Simulation();
        ArrayList<Item> items = simulation.loadItems(phase1);
        ArrayList<Rocket> u1RocketsP1 = simulation.loadU1(items);
        System.out.println("Total cost: $" + simulation.runSimulation(u1RocketsP1) + " Million");
        ArrayList<Rocket> u1RocketsP2 = simulation.loadU1(items);
        System.out.println("Total cost: $" + simulation.runSimulation(u1RocketsP2) + " Million");
        ArrayList<Rocket> u2RocketsP1 = simulation.loadU2(items);
        System.out.println("Total cost: $" + simulation.runSimulation(u2RocketsP1) + " Million");
        ArrayList<Rocket> u2RocketsP2 = simulation.loadU2(items);
        System.out.println("Total cost: $" + simulation.runSimulation(u2RocketsP2) + " Million");


    }
}
