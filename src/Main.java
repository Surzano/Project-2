public class Main {
    public static void main(String[] args){
        Simulation sim = new Simulation();
        sim.setup(false, 5);
        sim.run();
        sim.process();

    }
}
