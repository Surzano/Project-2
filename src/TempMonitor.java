public class TempMonitor extends Devices {
    public Observation read(int t){
        double newTemp = Math.round(Math.min(41.0, 37.0 + Simulation.getNextGaussian(2))*100.0)/100.0;
        return new Temperature(newTemp, t);
    }
}
