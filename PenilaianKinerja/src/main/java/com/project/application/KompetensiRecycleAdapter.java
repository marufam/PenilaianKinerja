package com.project.application;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.R;
import com.project.application.rest.pojo.Kompetensi_;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class KompetensiRecycleAdapter extends RecyclerView.Adapter<KompetensiRecycleAdapter.ViewHolder> {

    List<Kompetensi_> contents;
    Context a;
    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    public KompetensiRecycleAdapter(List<Kompetensi_> contents, Context a) {
        this.contents = contents;
        this.a = a;
    }


    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public KompetensiRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

//        switch (viewType) {
//            case TYPE_HEADER: {
//                view = LayoutInflater.from(parent.getContext())
//                        .inflate(R.layout.list_item_card_big, parent, false);
//                return new RecyclerView.ViewHolder(view) {
//                };
//            }
//            case TYPE_CELL: {
//
//            }
//        }
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card_small, parent, false);
        return new KompetensiRecycleAdapter.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Kompetensi_ model = contents.get(position);
        holder.isikompetensi.setText(model.getNamakompetensi());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "Kode Kompetensi : "+model.getKodekompetensi(), Toast.LENGTH_SHORT).show();
                Intent ab = new Intent(a, IndikatorActivity.class);
                ab.putExtra("kodekompetensi", model.getKodekompetensi().toString());
                ab.putExtra("namakompetensi", model.getNamakompetensi().toString());
                v.getContext().startActivity(ab);

            }
        });
    }



    public class ViewHolder extends  RecyclerView.ViewHolder{
        CardView cardView;
        TextView isikompetensi;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_viewkompetensi);
            isikompetensi = (TextView) itemView.findViewById(R.id.isikompetensi);
        }
    }
}