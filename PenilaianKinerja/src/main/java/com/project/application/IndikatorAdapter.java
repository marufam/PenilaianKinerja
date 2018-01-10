package com.project.application;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.R;
import com.project.application.rest.pojo.Nilai;
import com.project.application.rest.pojo.Nilai_;

import java.util.List;

/**
 * Created by amien on 04/01/18.
 */

public class IndikatorAdapter extends RecyclerView.Adapter<IndikatorAdapter.ViewHolder> {
    private List<Nilai_> items;
    Context a;
    public IndikatorAdapter(List<Nilai_> ab, Context a) {
        this.a=a;
        this.items = ab;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_item_indikator,parent, false);
        return new IndikatorAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Nilai_ model = items.get(position);
        holder.isiindikator.setText(model.getIsiindikator().toString());
        holder.nilai.setText(model.getNilai().toString());
        holder.cardView_indikator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(a, "Clicked..", Toast.LENGTH_SHORT).show();
            }
        });
//        holder.isiindikator.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView_indikator ;
        TextView isiindikator, nilai;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView_indikator = (CardView) itemView.findViewById(R.id.card_viewindikator);
            isiindikator = (TextView) itemView.findViewById(R.id.isiIndikator);
            nilai = (TextView) itemView.findViewById(R.id.nilai);
        }
    }
}
