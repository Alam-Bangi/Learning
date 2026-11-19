package tryouts.multi_threading;

class RedLight extends Thread {
    public void run() {
        try {
            System.out.println("RED LIGHT - STOP");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class YellowLight extends Thread {
    public void run() {
        try {
            System.out.println("YELLOW LIGHT - WAIT");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class GreenLight extends Thread {
    public void run() {
        try {
            System.out.println("GREEN LIGHT - GO");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class TrafficLights {
    public static void main(String[] args) {
        while (true) {
            RedLight r = new RedLight();
            YellowLight y = new YellowLight();
            GreenLight g = new GreenLight();

            r.start();
            try {
                r.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            y.start();
            try {
                y.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            g.start();
            try {
                g.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println();
        }
    }
}
