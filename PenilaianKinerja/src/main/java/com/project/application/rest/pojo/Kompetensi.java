package com.project.application.rest.pojo;

/**
 * Created by amien on 07/12/17.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kompetensi {

    @SerializedName("kompetensi")
    @Expose
    private List<Kompetensi_> kompetensi = null;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;

    public List<Kompetensi_> getKompetensi() {
        return kompetensi;
    }

    public void setKompetensi(List<Kompetensi_> kompetensi) {
        this.kompetensi = kompetensi;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

}