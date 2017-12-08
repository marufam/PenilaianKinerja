package com.project.application.rest.pojo;

/**
 * Created by amien on 07/12/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Komplain_{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("kodeguru")
    @Expose
    private String kodeguru;
    @SerializedName("kodepenilai")
    @Expose
    private String kodepenilai;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("status")
    @Expose
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKodeguru() {
        return kodeguru;
    }

    public void setKodeguru(String kodeguru) {
        this.kodeguru = kodeguru;
    }

    public String getKodepenilai() {
        return kodepenilai;
    }

    public void setKodepenilai(String kodepenilai) {
        this.kodepenilai = kodepenilai;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}