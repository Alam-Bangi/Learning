package tryouts.multi_threading;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class DigitalClock1 extends Thread {
    private JLabel timeLabel;

    public DigitalClock1(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }

    @Override
    public void run() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        while (true) {
            LocalTime time = LocalTime.now();

            SwingUtilities.invokeLater(() -> {
                timeLabel.setText(time.format(formatter));
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Clock stopped.");
                break;
            }
        }
    }
}

public class DigitalClockRunnerUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Digital Clock");

        JLabel title = new JLabel("DIGITAL CLOCK");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);

        JLabel timeLabel = new JLabel();
        timeLabel.setFont(new Font("Digital-7", Font.BOLD, 55));
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 20));
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));

        panel.add(title, BorderLayout.NORTH);
        panel.add(timeLabel, BorderLayout.CENTER);

        frame.add(panel);

        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        DigitalClock1 clock = new DigitalClock1(timeLabel);
        clock.start();
    }
}
