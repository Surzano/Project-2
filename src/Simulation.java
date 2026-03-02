import java.util.Random;
public class Simulation {
    //Setup
    public void setup(){
        System.out.println("Setting up Simulation...");
    }

    public static Random rng = new Random();
    private int currentTime;
    private int totalTime;

    private Hospital hos;

    public Simulation() {
        currentTime = 0;
        totalTime = 90;
    }

    public static int getRandomNumber(int bound){
        return rng.nextInt(bound);
    }

    public Hospital getHospital() {
        return hos;
    }

    //Run
    public void run() {
        System.out.println("Runing Simulation..");
        while (currentTime < totalTime) {
            currentTime += 5;

        }
    }




    //Process
    public void process() {
        System.out.println("Processing data...");
    }

}
