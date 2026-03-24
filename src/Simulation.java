

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
            for(Patient p : patients) p.genAlerts(currentTime, SimHospital);
            SimHospital.assignNurses();

            for (Nurse n : SimHospital.getStaff()){
                if (!n.isFree() && n.hasFinished(currentTime)){
                    Alert Finished = n.getWorkingOn();
                    Finished.getTime();
                    SimHospital.getCompleteQueue().enqueue(Finished);
                    n.clearTask();
                }
            }
            for(int i = 0; i < patients.length; i++){
                patients[i].genAlerts(currentTime, SimHospital );
            }
            currentTime += 1;
        }
    }

    //Process
    public void process() {
        int count = 0;
        int totalTime = 0;
        int maxTime = 0;

        while (SimHospital.getCompleteQueue().peek() != null) {
            Alert al = SimHospital.getCompleteQueue().dequeue();
            int resTime = al.getEndTime - al.getTime();
            totalTime += resTime;
            if (resTime > maxTime) maxTime = resTime;
            count++;
        }
        if (count > 0) {
            System.out.println("Average Resolution time: " + (double)totalTime / count);
            System.out.println("Max Resolution Time: " + maxTime);
        }


        System.out.println("Processing data...");
    }

}
