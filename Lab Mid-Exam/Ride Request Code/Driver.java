public class Driver {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    public void acceptRide(Ride ride) {
        if (ride.getStatus() == RideStatus.REQUESTED) {
            ride.setStatus(RideStatus.ACCEPTED);
            ride.setDriver(this);
            System.out.println(name + " accepted the ride.");
        }
    }

    public void rejectRide(Ride ride) {
        if (ride.getStatus() == RideStatus.REQUESTED) {
            ride.setStatus(RideStatus.REJECTED);
            System.out.println(name + " rejected the ride.");
        }
    }

    public void startRide(Ride ride) {
        if (ride.getStatus() == RideStatus.ACCEPTED) {
            ride.setStatus(RideStatus.IN_PROGRESS);
            System.out.println(name + " started the ride.");
        }
    }

    public void endRide(Ride ride) {
        if (ride.getStatus() == RideStatus.IN_PROGRESS) {
            ride.setStatus(RideStatus.COMPLETED);
            System.out.println(name + " ended the ride.");
        }
    }

    public String getName() {
        return name;
    }
}
