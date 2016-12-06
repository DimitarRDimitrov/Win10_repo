public class Main {

    float milesInAMarathon = 26.2f;
    double atomsWidthInMeters = 0.00000000001d;

    char regularU= 'U';
    boolean iLoveJava = true;

    int firstValue = 100;
    int otherValue = firstValue;
    // separate copy --> stored by value



    public static void main(String[] args) {
        Flight myFlight = new Flight(149);
        myFlight.add1Passenger();
        myFlight.add1Passenger();
        myFlight.add1Passenger();
        System.out.println(myFlight.printPasssengers());

    }
}
