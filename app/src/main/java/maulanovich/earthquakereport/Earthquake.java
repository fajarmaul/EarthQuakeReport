package maulanovich.earthquakereport;

/**
 * Created by Maulanovich on 06/03/2018.
 */

public class Earthquake {
    private double nMagnitude;
    private String nLocation;
    private long nTimeinMilisec;

    public Earthquake(double nMagnitude, String nLocation, long nTimeinMilisec){
        this.nMagnitude = nMagnitude;
        this.nLocation = nLocation;
        this.nTimeinMilisec = nTimeinMilisec;
    }
//Getter
    public double getnMagnitude() {
        return nMagnitude;
    }

    public String getnLocation() {
        return nLocation;
    }

    public long getnTimeinMilisec() {
        return nTimeinMilisec;
    }
//Setter
    public void setnMagnitude(double nMagnitude) {
        this.nMagnitude = nMagnitude;
    }

    public void setnLocation(String nLocation) {
        this.nLocation = nLocation;
    }

    public void setnTimeinMilisec(long nTimeinMilisec) {
        this.nTimeinMilisec= nTimeinMilisec;
    }


}
