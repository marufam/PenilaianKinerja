package com.project.application;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.materialviewpager.sample.R;
import com.project.application.rest.ApiClient;
import com.project.application.rest.ApiInterface;
import com.project.application.rest.pojo.Guru;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    TextView namaguru,nip,nuptk,nrg,tempat_lahir, tanggal_lahir, pangkat, jabatan, golongan, tmt, jeniskelamin, pendidikan, program, jam, masakerja, jenisguru;
    Button btnUpdate;
    SharedPreferences pref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Profile");
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode where the created file can only be accessed by the calling application
        namaguru = (TextView) findViewById(R.id.nama_guru);
        nip = (TextView) findViewById(R.id.nip);
        nuptk = (TextView) findViewById(R.id.nuptk);
        nrg = (TextView) findViewById(R.id.nrg);
        tempat_lahir = (TextView) findViewById(R.id.tempat_lahir);
        tanggal_lahir = (TextView) findViewById(R.id.tanggal_lahir);
        pangkat = (TextView) findViewById(R.id.pangkat);
        jabatan = (TextView) findViewById(R.id.jabatan);
        golongan = (TextView) findViewById(R.id.golongan);
        tmt = (TextView) findViewById(R.id.tmtguru);
        jeniskelamin = (TextView) findViewById(R.id.jeniskelamin);
        pendidikan = (TextView) findViewById(R.id.pendidikan);
        program = (TextView) findViewById(R.id.program);
        jam = (TextView) findViewById(R.id.jam);
        masakerja = (TextView) findViewById(R.id.masakerja);
        jenisguru = (TextView) findViewById(R.id.jenisguru);

        btnUpdate = (Button) findViewById(R.id.update_karyawan);

        ApiInterface mApiInterface = ApiClient.GetGuru().create(ApiInterface.class);
        Call<Guru> guruCall = mApiInterface.getGuruId(pref.getString("id_guru",null));
        guruCall.enqueue(new Callback<Guru>() {

            @Override
            public void onResponse(Call<Guru> call, Response<Guru> response) {
                Toast.makeText(ProfileActivity.this, "Guru " + response.body().getGuru().get(0).getNama().toString(), Toast.LENGTH_SHORT).show();
                namaguru.setText(response.body().getGuru().get(0).getNama().toString());
                nip.setText(response.body().getGuru().get(0).getNip().toString());
                nuptk.setText(response.body().getGuru().get(0).getNuptk().toString());
                nrg.setText(response.body().getGuru().get(0).getNrg().toString());
                tempat_lahir.setText(response.body().getGuru().get(0).getTempatlahir().toString());
                tanggal_lahir.setText(response.body().getGuru().get(0).getTanggallahir().toString());
                pangkat.setText(response.body().getGuru().get(0).getKodepangkat().toString());
                jabatan.setText(response.body().getGuru().get(0).getKodejabatan().toString());
                golongan.setText(response.body().getGuru().get(0).getKodegolongan().toString());
                tmt.setText(response.body().getGuru().get(0).getTmtguru().toString());
                jeniskelamin.setText(response.body().getGuru().get(0).getJeniskelamin().toString());
                pendidikan.setText(response.body().getGuru().get(0).getPendidikan().toString());
                program.setText(response.body().getGuru().get(0).getProgram().toString());
                jam.setText(response.body().getGuru().get(0).getJam().toString());
                masakerja.setText(response.body().getGuru().get(0).getMasakerja().toString());
                jenisguru.setText(response.body().getGuru().get(0).getJenisguru().toString());
            }

            @Override
            public void onFailure(Call<Guru> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Check your connection!!", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestBody reqKodeGuru = MultipartBody.create(MediaType.parse("multipart/form-data"),pref.getString("id_guru",null));
                RequestBody reqNamaGuru = MultipartBody.create(MediaType.parse("multipart/form-data"), namaguru.getText().toString());
                RequestBody reqNip = MultipartBody.create(MediaType.parse("multipart/form-data"), nip.getText().toString());
                RequestBody reqNuptk = MultipartBody.create(MediaType.parse("multipart/form-data"), nuptk.getText().toString());
                RequestBody reqNrg = MultipartBody.create(MediaType.parse("multipart/form-data"), nrg.getText().toString());
                RequestBody reqTempatLahir = MultipartBody.create(MediaType.parse("multipart/form-data"), tempat_lahir.getText().toString());
                RequestBody reqTanggalLahir = MultipartBody.create(MediaType.parse("multipart/form-data"), tanggal_lahir.getText().toString());
                RequestBody reqKodePangkat = MultipartBody.create(MediaType.parse("multipart/form-data"), pangkat.getText().toString());
                RequestBody reqKodeJabatan = MultipartBody.create(MediaType.parse("multipart/form-data"), jabatan.getText().toString());
                RequestBody reqKodeGolongan = MultipartBody.create(MediaType.parse("multipart/form-data"), golongan.getText().toString() );
                RequestBody reqTmtGuru = MultipartBody.create(MediaType.parse("multipart/form-data"), tmt.getText().toString() );
                RequestBody reqJenisKelamin = MultipartBody.create(MediaType.parse("multipart/form-data"), jeniskelamin.getText().toString() );
                RequestBody reqPendidikan = MultipartBody.create(MediaType.parse("multipart/form-data"), pendidikan.getText().toString());
                RequestBody reqProgram = MultipartBody.create(MediaType.parse("multipart/form-data"), program.getText().toString());
                RequestBody reqJam = MultipartBody.create(MediaType.parse("multipart/form-data"), jam.getText().toString() );
                RequestBody reqMasaKerja = MultipartBody.create(MediaType.parse("multipart/form-data"), masakerja.getText().toString() );
                RequestBody reqJenisGuru = MultipartBody.create(MediaType.parse("multipart/form-data"), jenisguru.getText().toString() );
                RequestBody action = MultipartBody.create(MediaType.parse("multipart/form-data"), "PUT");


                ApiInterface mApiInterface = ApiClient.GetGuru().create(ApiInterface.class);
                Call<Guru> guruCall = mApiInterface.guruedit(reqKodeGuru,
                        reqNip,
                        reqNuptk,
                        reqNrg,
                        reqNamaGuru,
                        reqTempatLahir,
                        reqTanggalLahir,
                        reqKodePangkat,
                        reqKodeJabatan,
                        reqKodeGolongan,
                        reqTmtGuru,
                        reqJenisKelamin,
                        reqPendidikan,
                        reqProgram,
                        reqJam,
                        reqMasaKerja,
                        reqJenisGuru,
                        action
                        );

                guruCall.enqueue(new Callback<Guru>() {

                    @Override
                    public void onResponse(Call<Guru> call, Response<Guru> response) {
                      //  Toast.makeText(ProfileActivity.this, ""+response.body().getGuru(), Toast.LENGTH_SHORT).show();
//                        Log.d("JSON", );
                        Toast.makeText(ProfileActivity.this, "Update Succsess!! ", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Guru> call, Throwable t) {
                        Toast.makeText(ProfileActivity.this, "Update Failed!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
