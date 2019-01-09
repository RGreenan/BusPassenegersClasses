import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBus {
    Person person;
    Bus bus;
    BusStop busStop;

    @Before
    public void before(){
        person = new Person();
        bus = new Bus("Mayfield", 5);
        busStop = new BusStop("Usher Hall");
    }

    @Test
    public void busHasDesination(){
        assertEquals("Mayfield", bus.getDestination());
    }

    @Test
    public void busHasCapacity(){
        assertEquals(5, bus.getCapacity());
    }

    @Test
    public void currentPassengers0(){
        assertEquals(0, bus.getCurrentPassengers());
    }

    @Test
    public void canAddPassenger(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(2, bus.getCurrentPassengers());
    }

    @Test
    public void tooManyPassengers(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(5, bus.getCurrentPassengers());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.removePassenger(0);
        assertEquals(1, bus.getCurrentPassengers());
    }

    @Test
    public void canAddToQueue(){
        busStop.addPersonToQueue(person);
        assertEquals(1, busStop.getQueueNumber());
    }

    @Test
    public void canRemovePersonFromQueue(){
        busStop.addPersonToQueue(person);
        busStop.addPersonToQueue(person);
        busStop.removePersonFromQueue(person);
        assertEquals(1, busStop.getQueueNumber());
    }

    @Test
    public void canPickUpPassenger(){
        busStop.addPersonToQueue(person);
        busStop.addPersonToQueue(person);
        busStop.addPersonToQueue(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.pickUpPassenger(person);
        assertEquals(2, busStop.getQueueNumber());
        assertEquals(3, bus.getCurrentPassengers());
    }
}
