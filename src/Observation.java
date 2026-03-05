public abstract class Observation {
    private int time;
    abstract boolean critical();
    abstract protected void setTime();
}
