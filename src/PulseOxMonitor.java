class PulseOxMonitor extends Devices {
    private int last = Simulation.getRandomNumber(5)+95;
    private boolean isDecreasing = true, isGood = true;

    public PulseOxMonitor(){ // sets up condition for patient
        if((Simulation.getRandomNumber(4) == 1)){
            isGood = false;
        }

        if(Simulation.getRandomNumber(2) == 1){
            isDecreasing = false;
        }
    }

    public Observation read(int t) {
        last = makeTemp();
        return new PulseOx(last, t);
    }

    private int makeTemp(){
        int maxBound = 100, minBound = 95;

        if(!isGood){
            if(isDecreasing){
                maxBound = last-Simulation.getRandomNumber(3);
                minBound = 80;
            }
        }
        return  Math.max(minBound, Math.min(Simulation.getRandomNumber(100), maxBound));
    }
}
