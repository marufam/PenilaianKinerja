package com.project.application.rest.pojo;

/**
 * Created by amien on 07/12/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Komplain {

    @SerializedName("komplain")
    @Expose
    private List<Komplain_> komplain = null;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;

    public List<Komplain_> getKomplain() {
        return komplain;
    }

    public void setKomplain(List<Komplain_> komplain) {
        this.komplain = komplain;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

}