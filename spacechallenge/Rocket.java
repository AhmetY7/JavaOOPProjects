package spacechallenge;

public class Rocket implements ISpaceShip {
    protected double rocketCost;
    protected double rocketWeight;
    protected double maxWeight;
    protected double currentWeight;
    protected double chanceOfLaunchExplosion;
    protected double chanceOfLandingCrash;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return !(currentWeight + item.getWeight() > maxWeight);
    }

    @Override
    public void carry(Item item) {
        currentWeight += item.getWeight();
    }
}
