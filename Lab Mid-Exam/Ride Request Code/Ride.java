public class Ride {
    private RideStatus status;
    private Driver driver;
    private User user;

    public Ride(User user) {
        this.user = user;
        this.status = RideStatus.REQUESTED;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public User getUser() {
        return user;
    }
}
