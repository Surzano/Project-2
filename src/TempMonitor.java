public class TempMonitor extends Devices {
    public Observation read(int t){
        double newTemp = Math.min(41.0, 37.0 + Simulation.getNextGaussian(2));
        return new Temperature(newTemp, t);
    }
}
