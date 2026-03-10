class PulseOxMonitor extends Devices {

    public Observation read(int t) {
        int simSpo2 = Simulation.getRandomNumber(21) + 80;
        PulseOx pom = new PulseOx(simSpo2, t);
        return pom;
    }

}
