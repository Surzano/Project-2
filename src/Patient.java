import java.util.UUID;

public class Patient {
    private UUID ID;

    public Patient() {
        ID = UUID.randomUUID();
    }

    public UUID getID() {
        return ID;
    }

    public String toString(){
        return "Patient ID: " + ID.toString();
    }

}
