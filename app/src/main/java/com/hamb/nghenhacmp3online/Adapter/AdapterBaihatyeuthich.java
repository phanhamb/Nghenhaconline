package com.hamb.nghenhacmp3online.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hamb.nghenhacmp3online.Model.Baihat;
import com.hamb.nghenhacmp3online.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterBaihatyeuthich extends RecyclerView.Adapter<AdapterBaihatyeuthich.ViewHolder> {


    Context context;
    ArrayList<Baihat> baihatArrayList;
    public AdapterBaihatyeuthich(Context context, ArrayList<Baihat> baihatArrayList) {
        this.context = context;
        this.baihatArrayList = baihatArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_baihatyeuthich,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baihat = baihatArrayList.get(position);
        holder.txtcasi.setText(baihat.getCasi());
        holder.txtten.setText(baihat.getTenbaihat());
        Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imghinh);

    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtten,txtcasi;
        ImageView imghinh,imgluotthich;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.textbaihatyeuthich);
            txtcasi = itemView.findViewById(R.id.texttencasibaihatyeuthich);
            imghinh = itemView.findViewById(R.id.imagebaihatyeuthich);
            imgluotthich = itemView.findViewById(R.id.imagyeuthich);


        }
    }

}
