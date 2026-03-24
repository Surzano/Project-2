public class BPMonitor extends Devices{
    private int lastSy, lastDias;
    private boolean isIncreasing = false, isGood = true;

    public Observation read(int t){
        lastSy = makeSystolic();
        lastDias = makeDiastolic();
        return new BloodPressure(lastSy, lastDias, t);
    }

    public BPMonitor(){ // sets up condition for patient
        if((Simulation.getRandomNumber(7) == 1)){
            isGood = false;
        }

        if(Simulation.getRandomNumber(2) == 1){
            isIncreasing = false;
        }
    }

    private int makeSystolic(){
        int maxBound = 120, minBound = 90;

        if(!isGood){
            if(isIncreasing){
                minBound = lastSy + Simulation.getRandomNumber(10);
                maxBound = Integer.MAX_VALUE;
            }else {
                maxBound = lastSy;
                minBound = 70;
            }
        }

        return  Math.max(minBound, Math.min(Simulation.getRandomNumber(31), maxBound));
    }

    private int makeDiastolic(){
        int maxBound = 60, minBound = 80;

        if(!isGood){
            if(isIncreasing){
                minBound = lastDias + Simulation.getRandomNumber(10);
                maxBound = Integer.MAX_VALUE;
            }else {
                maxBound = lastDias;
                minBound = 40;
            }
        }

        return  Math.max(minBound, Math.min(Simulation.getRandomNumber(100), maxBound));
    }
}
