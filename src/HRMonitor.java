class HRMonitor extends Devices {

    public Observation read(int t) {
        int simBpm = Simulation.getRandomNumber(101) + 40;
        HeartRate hrm = new HeartRate(simBpm, t);
        return hrm;

    }
}
