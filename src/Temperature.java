public class Temperature extends Observation{
    private int time;
    private double temp; // in celsius

    public Temperature(double tmp, int t){
        time = t;

        temp = tmp;
    }

    public double toFarenheit(){
        return Math.round((temp * 9/5 + 32)*100.0)/100.0;
    }

    public boolean critical(){
        return temp >= 39.4 || temp <= 35;

    }
    public String data() {
        return "Temperature: "+ temp + "°C ("+toFarenheit()+"°F) at time "+ time;
    }

}
