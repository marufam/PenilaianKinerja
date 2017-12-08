package com.project.application.rest;



import com.project.application.rest.pojo.Guru;
import com.project.application.rest.pojo.Indikator;
import com.project.application.rest.pojo.Kompetensi;
import com.project.application.rest.pojo.Komplain;
import com.project.application.rest.pojo.Nilai;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by amien on 01/05/17.
 */

public interface ApiInterface {

    @GET("index.php/Guru_api")
    Call<Guru> getGuru();

    @GET("index.php/Guru_api")
    Call<Guru> getGuruId(@Query("id") String id);

    @GET("index.php/Indikator_api")
    Call<Indikator> getIndikator();

    @GET("index.php/Indikator_api")
    Call<Indikator> getIndikatorId(@Query("id") String id);

    @GET("index.php/Kompetensi_api")
    Call<Kompetensi> getKompetensi();

    @GET("index.php/Kompetensi_api")
    Call<Kompetensi> getKompetensiId(@Query("id") String id);

    @GET("index.php/Komplain_api")
    Call<Komplain> getKomplain();

    @GET("index.php/Kompetensi_api")
    Call<Komplain> getKomplainId(@Query("id") String id);

    @GET("index.php/Nilai_api")
    Call<Nilai> getNilai();

    @GET("index.php/Kompetensi_api")
    Call<Nilai> getNilaiId(@Query("id") String id);

//    @GET("index.php/jadwal_api")
//    Call<GetJadwal> getJadwal(@Query("id_karyawan") String id_karyawan);
//    @GET("index.php/laporan_api")
//    Call<GetLaporan> getLaporan(@Query("id_karyawan") String id_karyawan);
//    @GET("index.php/lokasi_api")
//    Call<GetLokasi> getLokasi();
//

//    @Multipart
//    @POST("index.php/karyawan_api")
//    Call<GetKaryawan> uploadImage(@Part MultipartBody.Part foto,
//                                  @Part("id_karyawan") RequestBody id_karyawan,
//                                  @Part("nama_karyawan") RequestBody nama_karyawan,
//                                  @Part("tempat_lahir") RequestBody tempat_lahir,
//                                  @Part("tgl_lahir") RequestBody tgl_lahir,
//                                  @Part("alamat") RequestBody alamat,
//                                  @Part("jk") RequestBody jk,
//                                  @Part("username") RequestBody username,
//                                  @Part("password") RequestBody password,
//                                  @Part("action") RequestBody action);

            ;
}
