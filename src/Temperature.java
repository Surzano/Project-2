public class Temperature extends Observation{
    private int time;
    private double temp; // in celsius

    public Temperature(double tmp, int t){
        time = t;

        temp = tmp;
    }

    public double toFarenheit(){
        return temp * 9/5 + 32;
    }

    public boolean critical(){
        if(temp >= 39.4 || temp <= 35){
            return true;
        }

        return false;
    }
    public String data() {
        return "Temperature: "+ temp + "°C ("+toFarenheit()+"°F) at time "+ time;
    }

}
