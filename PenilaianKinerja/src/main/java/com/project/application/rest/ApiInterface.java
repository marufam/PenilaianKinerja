package com.project.application.rest;



import com.project.application.rest.pojo.Guru;
import com.project.application.rest.pojo.Indikator;
import com.project.application.rest.pojo.Kompetensi;
import com.project.application.rest.pojo.Komplain;
import com.project.application.rest.pojo.Nilai;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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
    @Multipart
    @POST("index.php/Guru_api")
    Call<Guru> loginguru(@Part("nip") RequestBody nip,
                         @Part("tanggallahir") RequestBody tanggallahir,
                         @Part("action") RequestBody action);

    @Multipart
    @POST("index.php/Guru_api")
    Call<Guru> guruedit(@Part("kodeguru") RequestBody kodeguru,
                                  @Part("nip") RequestBody nip,
                                  @Part("nuptk") RequestBody nuptk,
                                  @Part("nrg") RequestBody nrg,
                                  @Part("nama") RequestBody nama,
                                  @Part("tempatlahir") RequestBody tempatlahir,
                                  @Part("tanggallahir") RequestBody tanggallahir,
                                  @Part("kodepangkat") RequestBody kodepangkat,
                                  @Part("kodejabatan") RequestBody kodejabatan,
                           @Part("kodegolongan") RequestBody kodegolongan,
                           @Part("tmtguru") RequestBody tmtguru,
                           @Part("jeniskelamin") RequestBody jeniskelamin,
                           @Part("pendidikan") RequestBody pendidikan,
                           @Part("program") RequestBody program,
                           @Part("jam") RequestBody jam,
                           @Part("masakerja") RequestBody masakerja,
                           @Part("jenisguru") RequestBody jenisguru,
                        @Part("action") RequestBody action
                           );


}
