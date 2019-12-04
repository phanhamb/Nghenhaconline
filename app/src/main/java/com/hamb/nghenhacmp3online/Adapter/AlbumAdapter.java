package com.hamb.nghenhacmp3online.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hamb.nghenhacmp3online.Model.Album;
import com.hamb.nghenhacmp3online.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.Viewholder> {


    Context context;
    ArrayList<Album> mangalbum;

    public AlbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Album album = mangalbum.get(position);
        holder.txtcasialbum.setText(album.getTencasi());
        holder.txttenalbum.setText(album.getTenalbum());
        Picasso.with(context).load(album.getHinhalbum()).into(holder.imghinhalbum);
    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView imghinhalbum;
        TextView txttenalbum,txtcasialbum;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imghinhalbum = itemView.findViewById(R.id.imagealbum);
            txtcasialbum = itemView.findViewById(R.id.texttencasialbum);
            txttenalbum = itemView.findViewById(R.id.texttenalbum);
        }
    }
}
