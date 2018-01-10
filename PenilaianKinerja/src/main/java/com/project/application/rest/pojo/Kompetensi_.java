package com.project.application.rest.pojo;

/**
 * Created by amien on 07/12/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kompetensi_ {

    @SerializedName("kodekompetensi")
    @Expose
    private String kodekompetensi;
    @SerializedName("kodekategori")
    @Expose
    private String kodekategori;
    @SerializedName("namakompetensi")
    @Expose
    private String namakompetensi;

    public String getKodekompetensi() {
        return kodekompetensi;
    }

    public void setKodekompetensi(String kodekompetensi) {
        this.kodekompetensi = kodekompetensi;
    }

    public String getKodekategori() {
        return kodekategori;
    }

    public void setKodekategori(String kodekategori) {
        this.kodekategori = kodekategori;
    }

    public String getNamakompetensi() {
        return namakompetensi;
    }

    public void setNamakompetensi(String namakompetensi) {
        this.namakompetensi = namakompetensi;
    }

}