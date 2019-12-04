package com.hamb.nghenhacmp3online.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hamb.nghenhacmp3online.Model.Album;
import com.hamb.nghenhacmp3online.Model.Theloai;
import com.hamb.nghenhacmp3online.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TheLoaiAdapter extends RecyclerView.Adapter<TheLoaiAdapter.Viewholder> {
    public TheLoaiAdapter(Context context, ArrayList<Theloai> mangtheloai) {
        this.context = context;
        this.mangtheloai = mangtheloai;
    }

    Context context;
    ArrayList<Theloai> mangtheloai;
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_theloai,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Theloai theloai = mangtheloai.get(position);
        holder.txttentheloai.setText(theloai.getTenTheLoai());
        Picasso.with(context).load(theloai.getHinhTheLoai()).into(holder.imghinhtheloai);

    }

    @Override
    public int getItemCount() {
        return mangtheloai.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imghinhtheloai;
        TextView txttentheloai;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imghinhtheloai = itemView.findViewById(R.id.imagetheloai);
            txttentheloai = itemView.findViewById(R.id.texttentheloai);
        }
    }
}
