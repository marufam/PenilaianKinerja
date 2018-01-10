package com.project.application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.R;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.project.application.rest.ApiClient;
import com.project.application.rest.ApiInterface;
import com.project.application.rest.pojo.Guru;
import com.project.application.rest.pojo.Kompetensi;
import com.project.application.rest.pojo.Nilai;
import com.project.application.rest.pojo.Nilai_;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndikatorActivity extends AppCompatActivity {
    TextView namaguru,nip,nuptk,nrg,tempat_lahir, tanggal_lahir, pangkat, jabatan, golongan, tmt, jeniskelamin, pendidikan, program, jam, masakerja, jenisguru;
    Button btnUpdate;
    SharedPreferences pref ;
    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;

    private RecyclerView mRecycleview;
    private RecyclerView.LayoutManager mLayoutmanager;
    private RecyclerView.Adapter mAdapter;
    private List<Nilai_> mIndikator= new ArrayList<>();
    ApiInterface mApiInterface;
//    CardView cardnull;
    TextView cardnull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indikator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Indikator");
        cardnull = (TextView) findViewById(R.id.card_viewnull);
        ImageView im = (ImageView)findViewById(R.id.header_logo);
        Intent i = getIntent();
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode where the created file can only be accessed by the calling application
        Picasso.with(getApplicationContext()).load("http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg").into(im);
        TextView isi = (TextView) findViewById(R.id.isikompetensi);
        isi.setText(i.getStringExtra("namakompetensi"));

        mRecycleview = (RecyclerView) findViewById(R.id.recycler_indikator);
        mLayoutmanager = new LinearLayoutManager(getApplicationContext());
        mRecycleview.setLayoutManager(mLayoutmanager);


        ApiInterface mApiInterface = ApiClient.GetNilai().create(ApiInterface.class);
        Call<Nilai> nilai_call = mApiInterface.getNilaiid(pref.getString("kodeguru",null), i.getStringExtra("kodekompetensi"));
//        Call<Nilai> logincall = mApiInterface.getNilai();
        nilai_call.enqueue(new Callback<Nilai>() {

            @Override
            public void onResponse(Call<Nilai> call, Response<Nilai> response) {
                if (response.body().getNilai().size()>0) {
                    mIndikator = response.body().getNilai();
                    mAdapter = new IndikatorAdapter(mIndikator, getApplicationContext());
                    mRecycleview.setAdapter(mAdapter);
                    mRecycleview.setVisibility(View.VISIBLE);
                    cardnull.setVisibility(View.GONE);
                }else{
                    mRecycleview.setVisibility(View.INVISIBLE);
                    cardnull.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<Nilai> call, Throwable t) {
                Toast.makeText(IndikatorActivity.this, "Check your internet connection!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
