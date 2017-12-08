package com.project.application.rest.pojo;

/**
 * Created by amien on 07/12/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Indikator_ {

    @SerializedName("kodeindikator")
    @Expose
    private String kodeindikator;
    @SerializedName("kodekompetensi")
    @Expose
    private String kodekompetensi;
    @SerializedName("isiindikator")
    @Expose
    private String isiindikator;

    public String getKodeindikator() {
        return kodeindikator;
    }

    public void setKodeindikator(String kodeindikator) {
        this.kodeindikator = kodeindikator;
    }

    public String getKodekompetensi() {
        return kodekompetensi;
    }

    public void setKodekompetensi(String kodekompetensi) {
        this.kodekompetensi = kodekompetensi;
    }

    public String getIsiindikator() {
        return isiindikator;
    }

    public void setIsiindikator(String isiindikator) {
        this.isiindikator = isiindikator;
    }

}