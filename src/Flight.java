/**
 * Created by Dimitar on 18/11/2016.
 */
public class Flight {
    private int passengers;
    private int seats = 150;

    public Flight(int passngr) {
        passengers = passngr;
    }

    public Flight () {
        passengers = 0;
    }

    public void add1Passenger() {
        if (seats > passengers) {
            passengers += 1;
        }
        else {
            printError();
        }
    }

    private void printError() {
        System.out.println("NO MORE SEATS");
    }

    public int printPasssengers() {
        return passengers;
    }



}
