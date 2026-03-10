public class HPMonitor extends Devices{
    public Observation read(int t){
        int systolic = 90 + Simulation.getRandomNumber(31);   // 90–120
        int diastolic = 60 + Simulation.getRandomNumber(21);

        return new HeartPressure(systolic, diastolic, t);
    }
}
