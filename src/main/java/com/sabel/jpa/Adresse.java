package com.sabel.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Adresse {


    // DATA FIELDS

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String strasse;
    private String hausnummer;
    private int plz;
    private String ort;

    // CONSTRUCTORS
    public Adresse() {
    }

    public Adresse(String strasse, String hausnummer, int plz, String ort) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }

    // GETTER AND SETTER
    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return plz == adresse.plz &&
                Objects.equals(strasse, adresse.strasse) &&
                Objects.equals(hausnummer, adresse.hausnummer) &&
                Objects.equals(ort, adresse.ort);
    }

    @Override
    public int hashCode() {

        return Objects.hash(strasse, hausnummer, plz, ort);
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "strasse='" + strasse + '\'' +
                ", hausnummer='" + hausnummer + '\'' +
                ", plz=" + plz +
                ", ort='" + ort + '\'' +
                '}';
    }

} // END CLAS ADRESSE
