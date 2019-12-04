package com.hamb.nghenhacmp3online.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hamb.nghenhacmp3online.Model.Playlist;
import com.hamb.nghenhacmp3online.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class Viewholder{
        TextView txttenplaylist;
        ImageView imgbackground,imgplaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Viewholder viewholder = null;
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist,null);
            viewholder = new Viewholder();
            viewholder.txttenplaylist=convertView.findViewById(R.id.texttenplaylist);
            viewholder.imgbackground=convertView.findViewById(R.id.backgroundplaylist);
            viewholder.imgplaylist=convertView.findViewById(R.id.imageviewplaylist);
            convertView.setTag(viewholder);;

        }else {
            viewholder = (Viewholder) convertView.getTag();
        }
        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhPlaylist()).into(viewholder.imgbackground);
        Picasso.with(getContext()).load(playlist.getIcon()).into(viewholder.imgplaylist);
        viewholder.txttenplaylist.setText(playlist.getTen());
        return convertView;
    }
}
