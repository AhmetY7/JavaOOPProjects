package spacechallenge;

public class U2 extends Rocket {
    public U2() {
        rocketCost = 120;
        rocketWeight = 18_000;
        maxWeight = 29_000;
        currentWeight = rocketWeight;
        chanceOfLaunchExplosion = chanceOfLaunchExp();
        chanceOfLandingCrash = chanceOfLandingCrash();
    }

    @Override
    public boolean launch() {
        return !(chanceOfLaunchExplosion > Math.random());
    }

    @Override
    public boolean land() {
        return !(chanceOfLandingCrash > Math.random());
    }
    private double chanceOfLaunchExp(){
        return (4.0/100) * (currentWeight / maxWeight);
    }

    private double chanceOfLandingCrash() {
        return (8.0/100) * (currentWeight / maxWeight);
    }
}
