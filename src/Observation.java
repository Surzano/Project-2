public abstract class Observation {
    private int time;
    abstract boolean critical();
    protected final void setTime(int t){
        time = t;
    }
    private int sev;
    public Observation() {

    }

    public abstract String data();
}
