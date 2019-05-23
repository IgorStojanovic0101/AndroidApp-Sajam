package com.example.mykotlinapp.automobili;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sawyer on 6/3/2017.
 */

public class Auto {
    @SerializedName("naziv")
    String naziv;
    @SerializedName("ks")
     String ks;
    @SerializedName("poreklo")
    String poreklo;
    @SerializedName("marka")
    String marka;
    @SerializedName("boja")
    String  boja;
    @SerializedName("id")
    String id;
    @SerializedName("broj_sedista")
    String broj_sedista;
    @SerializedName("cena")
    String cena;
    @SerializedName("slika")
    byte [] slika;


    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
    }



    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    public void setPoreklo(String poreklo) {
        this.poreklo = poreklo;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }



    public void setBoja(String boja) {
        this.boja = boja;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setBroj_sedista(String broj_sedista) {
        this.broj_sedista = broj_sedista;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getKs() {
        return ks;
    }

    public String getPoreklo() {
        return poreklo;
    }

    public String getMarka() {
        return marka;
    }



    public String getBoja() {
        return boja;
    }

    public String getId() {
        return id;
    }



    public String getBroj_sedista() {
        return broj_sedista;
    }

    public Auto(String id, String naziv, String poreklo, String ks, String marka, String boja, String broj_sedista, String cena,byte [] slika) {
        this.naziv = naziv;
        this.ks = ks;
        this.poreklo = poreklo;
        this.marka = marka;
        this.boja = boja;
        this.broj_sedista = broj_sedista;
        this.cena=cena;
        this.id = id;
        this.slika=slika;


    }
}


