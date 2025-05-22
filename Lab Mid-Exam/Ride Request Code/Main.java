import javax.swing.*;
import java.awt.*;

public class Main {
    private static Ride ride;
    private static User user;
    private static Driver driver;
    private static JLabel statusLabel;

    public static void main(String[] args) {
        user = new User("Ahmed");
        driver = new Driver("Ali");

        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Smart Traveling Ride System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(new GridLayout(0, 1, 10, 10));

        JButton sendRequestBtn = new JButton("Send Ride Request");
        JButton cancelRequestBtn = new JButton("Cancel Ride Request");
        JButton acceptRideBtn = new JButton("Driver Accept Ride");
        JButton rejectRideBtn = new JButton("Driver Reject Ride");
        JButton startRideBtn = new JButton("Start Ride");
        JButton endRideBtn = new JButton("End Ride");

        statusLabel = new JLabel("Status: No Ride", SwingConstants.CENTER);

        sendRequestBtn.addActionListener(e -> {
            ride = new Ride(user);
            user.sendRideRequest(ride);
            updateStatus();
        });

        cancelRequestBtn.addActionListener(e -> {
            if (ride != null) {
                user.cancelRideRequest(ride);
                updateStatus();
            }
        });

        acceptRideBtn.addActionListener(e -> {
            if (ride != null) {
                driver.acceptRide(ride);
                updateStatus();
            }
        });

        rejectRideBtn.addActionListener(e -> {
            if (ride != null) {
                driver.rejectRide(ride);
                updateStatus();
            }
        });

        startRideBtn.addActionListener(e -> {
            if (ride != null) {
                driver.startRide(ride);
                updateStatus();
            }
        });

        endRideBtn.addActionListener(e -> {
            if (ride != null) {
                driver.endRide(ride);
                updateStatus();
            }
        });

        frame.add(sendRequestBtn);
        frame.add(cancelRequestBtn);
        frame.add(acceptRideBtn);
        frame.add(rejectRideBtn);
        frame.add(startRideBtn);
        frame.add(endRideBtn);
        frame.add(statusLabel);

        frame.setVisible(true);
    }

    private static void updateStatus() {
        if (ride != null) {
            statusLabel.setText("Status: " + ride.getStatus().toString());
        } else {
            statusLabel.setText("Status: No Ride");
        }
    }
}
