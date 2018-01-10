package com.project.application.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.florent37.R;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.project.application.KompetensiRecycleAdapter;
import com.project.application.rest.ApiClient;
import com.project.application.rest.ApiInterface;
import com.project.application.rest.pojo.Kompetensi;
import com.project.application.rest.pojo.Kompetensi_;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class SosialViewFragment extends Fragment {

    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    SharedPreferences pref;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public static SosialViewFragment newInstance() {
        return new SosialViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        final List<Kompetensi_> items = new ArrayList<>();


        pref = getActivity().getSharedPreferences("MyPref", 0); // 0 - for private mode where the created file can only be accessed by the calling application

//        Toast.makeText(getActivity(), "Jenis Guru : "+pref.getString("jenisguru", null), Toast.LENGTH_SHORT).show();

        String kodeguru = pref.getString("kodeguru",null);
        String Jenisguru = pref.getString("jenisguru", null);
        String kodekategori;
//        Toast.makeText(getContext(), ""+Jenisguru.toString(), Toast.LENGTH_SHORT).show();
        if(Jenisguru.toString().equalsIgnoreCase("guru matpel")){
             kodekategori = "KTG0000003";
        }else{
             kodekategori = "KTG0000007";
        }

        ApiInterface mApiInterface = ApiClient.GetKompetensi().create(ApiInterface.class);
        Call<Kompetensi> logincall = mApiInterface.getKompetensiId(kodekategori);
//        Call<Nilai> logincall = mApiInterface.getNilai();
        logincall.enqueue(new Callback<Kompetensi>() {

            @Override
            public void onResponse(Call<Kompetensi> call, Response<Kompetensi> response) {
//                Toast.makeText(getContext(), "Response "+response.body().getNilai().size(), Toast.LENGTH_SHORT).show();
                for (int i = 0; i < response.body().getKompetensi().size(); i++) {
                    items.add(response.body().getKompetensi().get(i));
                }
            }

            @Override
            public void onFailure(Call<Kompetensi> call, Throwable t) {
                Toast.makeText(getContext(), "Lost connection!!", Toast.LENGTH_SHORT).show();
                Log.d("Error Recycle ", t.toString());
            }
        });

        //setup materialviewpager

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(new KompetensiRecycleAdapter(items, getActivity()));
    }
}
