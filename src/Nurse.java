public class Nurse {
    private Alert workingOn;
    private int experienceLevel;

    public Nurse(){
        experienceLevel = Simulation.getRandomNumber(5);
    }

    public void giveTask(Alert al){
        workingOn = al;
        workingOn.alertIsAssigned(this);
    }

    public int getExperience(){ return experienceLevel; }

    public void clearTask() {
        this.workingOn = null;
    }

    public boolean isFree() {
        return workingOn == null;
    }

    public boolean hasFinished(int currentTime){
        Nurse[] nurses = workingOn.getNursesWorking();
        int exp = 0;
        for(int i = 0; i < nurses.length; i++){
            if(nurses[i] != null){
                exp += nurses[i].getExperience();
            }
        }
        return currentTime-workingOn.getTime() >= (workingOn.getDuration())/(Math.pow(.95, exp));
    }
    public Alert getWorkingOn(){
        return workingOn;
    }
}
