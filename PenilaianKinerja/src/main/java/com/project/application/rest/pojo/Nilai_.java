package com.project.application.rest.pojo;

/**
 * Created by amien on 07/12/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nilai_ {

    @SerializedName("kodepenilaian")
    @Expose
    private String kodepenilaian;
    @SerializedName("kodeguru")
    @Expose
    private String kodeguru;
    @SerializedName("kodeindikator")
    @Expose
    private String kodeindikator;
    @SerializedName("nilai")
    @Expose
    private String nilai;
    @SerializedName("kodepenilai")
    @Expose
    private String kodepenilai;
    @SerializedName("nomorsk")
    @Expose
    private String nomorsk;
    @SerializedName("tanggalsk")
    @Expose
    private String tanggalsk;
    @SerializedName("berlaku")
    @Expose
    private String berlaku;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("kodekompetensi")
    @Expose
    private String kodekompetensi;
    @SerializedName("isiindikator")
    @Expose
    private String isiindikator;
    @SerializedName("kodekategori")
    @Expose
    private String kodekategori;
    @SerializedName("namakompetensi")
    @Expose
    private String namakompetensi;
    @SerializedName("kode_guru")
    @Expose
    private String kodeGuru;

    public String getKodepenilaian() {
        return kodepenilaian;
    }

    public void setKodepenilaian(String kodepenilaian) {
        this.kodepenilaian = kodepenilaian;
    }

    public String getKodeguru() {
        return kodeguru;
    }

    public void setKodeguru(String kodeguru) {
        this.kodeguru = kodeguru;
    }

    public String getKodeindikator() {
        return kodeindikator;
    }

    public void setKodeindikator(String kodeindikator) {
        this.kodeindikator = kodeindikator;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getKodepenilai() {
        return kodepenilai;
    }

    public void setKodepenilai(String kodepenilai) {
        this.kodepenilai = kodepenilai;
    }

    public String getNomorsk() {
        return nomorsk;
    }

    public void setNomorsk(String nomorsk) {
        this.nomorsk = nomorsk;
    }

    public String getTanggalsk() {
        return tanggalsk;
    }

    public void setTanggalsk(String tanggalsk) {
        this.tanggalsk = tanggalsk;
    }

    public String getBerlaku() {
        return berlaku;
    }

    public void setBerlaku(String berlaku) {
        this.berlaku = berlaku;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getKodeGuru() {
        return kodeGuru;
    }

    public void setKodeGuru(String kodeGuru) {
        this.kodeGuru = kodeGuru;
    }


}