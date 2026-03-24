public class TempMonitor extends Devices {
    private double last = Math.min(Math.round(Math.min(41.0, 37.0 + Simulation.getNextGaussian(2))*100.0)/100.0, 36.5);
    private boolean isIncreasing = true, isGood = true;


    public Observation read(int t) {
        last = makeTemp();
        return new Temperature(last, t);
    }

    public TempMonitor(){ // sets up condition for patient
        if((Simulation.getRandomNumber(7) == 1)){
            isGood = false;
        }

        if(Simulation.getRandomNumber(2) == 1){
            isIncreasing = false;
        }
    }

    private double makeTemp(){
        double maxBound = 37.2, minBound = 36.1;

        if(!isGood){
            if(isIncreasing){
                minBound = (last + Simulation.getRandomNumber(10))/10;
                maxBound = 41.0;
            }else {
                maxBound = last;
                minBound = 32.0;
            }
        }

        return  Math.round(Math.max(minBound, Math.min(37.0 + Simulation.getNextGaussian(2), maxBound))*100)/100.0;
    }
}
