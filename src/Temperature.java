public class Temperature extends Observation{
    private int time;
    private double temp; // in celsius
    private int sev;

    public int getSeverity() {return sev;}

    public Temperature(double tmp, int t){
        time = t;

        temp = tmp;

        if(temp > 37.5 || temp < 35.5){
            sev = 1;
            if(temp > 38.5 || temp < 33.5){
                sev = 2;
                if(temp >= 40 || temp < 32){
                    sev = 3;
                }
            }
        }
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
