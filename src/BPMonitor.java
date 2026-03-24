public class BPMonitor extends Devices{
    private int lastSy, lastDias;
    private boolean isIncreasing = false, isGood = true;

    public Observation read(int t){
        int systolic = 90 + Simulation.getRandomNumber(31);   // 90–120
        int diastolic = 60 + Simulation.getRandomNumber(21);

        lastSy = makeSystolic();
        lastDias = makeDiastolic();
        return new BloodPressure(lastSy, lastDias, t);
    }

    private int last = Math.max(70, Math.min(Simulation.getRandomNumber(100), 100));

    public BPMonitor(){ // sets up condition for patient
        if((Simulation.getRandomNumber(4) == 1)){
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
                minBound = last + Simulation.getRandomNumber(10);
                maxBound = Integer.MAX_VALUE;
            }else {
                maxBound = last;
                minBound = 70;
            }
        }

        return  Math.max(minBound, Math.min(Simulation.getRandomNumber(31), maxBound));
    }

    private int makeDiastolic(){
        int maxBound = 60, minBound = 80;

        if(!isGood){
            if(isIncreasing){
                minBound = last + Simulation.getRandomNumber(10);
                maxBound = Integer.MAX_VALUE;
            }else {
                maxBound = last;
                minBound = 40;
            }
        }

        return  Math.max(minBound, Math.min(Simulation.getRandomNumber(100), maxBound));
    }
}
