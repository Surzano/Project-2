public abstract class Observation {
    private int time;
    abstract boolean critical();
    abstract int getSeverity();
    private int sev;
    public Observation() {

    }


    public abstract String data();

}
