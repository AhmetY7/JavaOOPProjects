package spacechallenge;

public class U1 extends Rocket {
    public U1() {
        rocketCost = 100;
        rocketWeight = 10_000;
        maxWeight = 18_000;
        currentWeight = rocketWeight;
        chanceOfLaunchExplosion = chanceOfLaunchExp();
        chanceOfLandingCrash = chanceOfLandingCrash();
    }
    @Override
    public boolean launch() {
        double deneme = Math.random();
        return !(chanceOfLaunchExplosion > deneme);
    }

    @Override
    public boolean land() {
        return !(chanceOfLandingCrash > Math.random());
    }

    private double chanceOfLaunchExp(){
        return (5.0/100) * (currentWeight / maxWeight);
    }

    private double chanceOfLandingCrash() {
        return (1.0/100) * (currentWeight / maxWeight);
    }
}
