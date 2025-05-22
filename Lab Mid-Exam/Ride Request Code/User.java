public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void sendRideRequest(Ride ride) {
        ride.setStatus(RideStatus.REQUESTED);
        System.out.println(name + " sent a ride request.");
    }

    public void cancelRideRequest(Ride ride) {
        if (ride.getStatus() == RideStatus.REQUESTED) {
            ride.setStatus(RideStatus.CANCELLED);
            System.out.println(name + " cancelled the ride request.");
        }
    }

    public String getName() {
        return name;
    }
}
