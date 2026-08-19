package tryouts.thread;

class OrderThread extends Thread {
    private String taskName;

    OrderThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " started");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(taskName + " completed");
    }
}
