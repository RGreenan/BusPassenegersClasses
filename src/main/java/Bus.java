import java.util.ArrayList;

public class Bus {
    private String destination;
    private int capacity;
    private ArrayList<Person> passengers;

    public Bus(String destination, int capacity){
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<Person>();
    }

    public String getDestination(){
        return destination;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getCurrentPassengers(){
        return passengers.size();
    }

    public void addPassenger(Person person){
        if (this.passengers.size() < this.capacity){
            passengers.add(person);
        } else {
            System.out.println("Bus too full");

        }
    }

    public void removePassenger(int index){
        this.passengers.remove(index);
    }

    public void pickUpPassenger(Person person){
        this.addPassenger(person);

    }

    public void pickUpPassengerFromStop(BusStop bs, Person person){
        this.addPassenger(person);

    }

}
