package com.project.application.rest.pojo;

/**
 * Created by amien on 07/12/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Indikator {

    @SerializedName("indikator")
    @Expose
    private List<Indikator_> indikator = null;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;

    public List<Indikator_> getIndikator() {
        return indikator;
    }

    public void setIndikator(List<Indikator_> indikator) {
        this.indikator = indikator;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}