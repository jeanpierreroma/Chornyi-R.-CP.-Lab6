package task;
import java.io.Serializable;

public class Address implements Serializable {
    private final String street;
    private final int buildingNumber;
    private final int flatNumber;

    public Address(String street, int buildingNumber, int flatNumber) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    @Override
    public String toString() {
        return "Адреса: " +
                "вул. " + street +
                ", буд. " + buildingNumber +
                ", кв." + flatNumber;
    }
}
