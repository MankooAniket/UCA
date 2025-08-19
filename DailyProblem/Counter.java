import java.util.*;

public class Counter implements Runnable {
    private boolean running = false;
    private boolean exit = false;
    private int count = 0;

    @Override
    public void run() {
        try {
            while(!exit) {
                if(running) {
                    System.out.println(count++);
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(100);
                }
            }   
         } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
        }
        System.out.println("Thread exited...");
    }

    public void startCounting() {
        running = true;
    }

    public void stopCounting() {
        running = false;
    }

    public void exit() {
        exit = true;
    }

    public static void main(String[] args) {
        Counter countDown = new Counter();
        Thread thread = new Thread(countDown);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Command: start, stop, exit");

        while(true) {
            String command = scanner.nextLine().trim().toLowerCase();

            switch(command) {
                case "start":
                    countDown.startCounting();
                    break;
                case "stop":
                    countDown.stopCounting();
                    break;
                case "exit":
                    countDown.exit();
                    try {
                        thread.join();
                    } catch(InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Use start, stop or exit.");
            }
        }   
    }
}

