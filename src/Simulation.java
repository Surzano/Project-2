import java.util.Random;
public class Simulation {
    public static Random rng = new Random();
    private int currentTime;
    private int totalTime;
    private Hospital SimHospital;
    //Setup
    public void setup(){
        System.out.println("Setting up Simulation...");
        SimHospital = new Hospital("parameters.csv");
    }

    public Simulation() {
        currentTime = 0;
        totalTime = 90;
    }

    public static int getRandomNumber(int bound){
        return rng.nextInt(bound);
    }
    public static double getNextGaussian(double factor){ return  rng.nextGaussian() * factor; }

    public Hospital getHospital() {
        return SimHospital;
    }

    //Run
    public void run() {
        System.out.println("Runing Simulation..");
        while (currentTime < totalTime) {
            Patient[] patients = SimHospital.getPatients();
            for(int i = 0; i < patients.length; i++){
                patients[i].genAlerts(currentTime);
            }
            currentTime += 5;
        }
    }




    //Process
    public void process() {
        System.out.println("Processing data...");
    }

}
