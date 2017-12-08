package com.project.application.rest.pojo;

/**
 * Created by amien on 07/12/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Guru {

    @SerializedName("guru")
    @Expose
    private List<Guru_> guru = null;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;

    public List<Guru_> getGuru() {
        return guru;
    }

    public void setGuru(List<Guru_> guru) {
        this.guru = guru;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

}