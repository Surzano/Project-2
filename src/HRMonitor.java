class HRMonitor extends Devices {
    private int last = Math.max(70, Math.min(Simulation.getRandomNumber(100), 100));
    private boolean isIncreasing = true, isGood = true;

    public HRMonitor(){ // sets up condition for patient
        if((Simulation.getRandomNumber(4) == 1)){
            isGood = false;
        }

        if(Simulation.getRandomNumber(2) == 1){
            isIncreasing = false;
        }
    }

    public Observation read(int t) {
        last = makeTemp();
        return new HeartRate(last, t);
    }

    private int makeTemp(){
        int maxBound = 100, minBound = 61;

        if(!isGood){
            if(isIncreasing){
                minBound = last + Simulation.getRandomNumber(10);
                maxBound = Integer.MAX_VALUE;
            }else {
                maxBound = last;
                minBound = 20;
            }
        }

        return  Math.max(minBound, Math.min(Simulation.getRandomNumber(100), maxBound));
    }
}
