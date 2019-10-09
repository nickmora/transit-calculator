import java.util.Arrays;

class TransitCalculator {
    int daysInCity;
    int numOfRides;

    public TransitCalculator(int days, int rides) {
        daysInCity = days;
        numOfRides = rides;
    }

    static double[] fareTypes = { 2.75, 33.00, 127.00 };

    public static double unlimited7Price(int days, int rides) {
        double finalPrice;
        int numOfPasses = days / 7;
        if (days != 0 && days % 7 != 0) {
            numOfPasses += 1;
        }
        // System.out.println(numOfPasses);
        finalPrice = numOfPasses * fareTypes[1] / rides;

        return finalPrice;
    }

    public static double[] getRidePrices(int days, int rides){
        double[] fares = new double[3];
        fares[0] = fareTypes[0] * rides/days;
        fares[1] = unlimited7Price(days, rides);
        fares[2] = fareTypes[2]/days;
        return fares;
    }

    public static void main(String[] args) {
        TransitCalculator newYork = new TransitCalculator(10, 15);
        // System.out.println(newYork.daysInCity);
        // System.out.println(newYork.numOfRides);
        // double[] final = getRidePrices(15, 30);
        double lowestCost = 100;
        for (double thing : getRidePrices(15, 30)){
            System.out.println(thing);
            if (thing < lowestCost){
                lowestCost = thing;
            }
        }
        System.out.println("You should purchase the x option at " + lowestCost + " per ride");

    }
}