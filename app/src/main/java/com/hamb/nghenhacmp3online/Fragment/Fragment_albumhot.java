package com.hamb.nghenhacmp3online.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hamb.nghenhacmp3online.Adapter.AlbumAdapter;
import com.hamb.nghenhacmp3online.Model.Album;
import com.hamb.nghenhacmp3online.Model.Playlist;
import com.hamb.nghenhacmp3online.R;
import com.hamb.nghenhacmp3online.Service.APIservice;
import com.hamb.nghenhacmp3online.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_albumhot extends Fragment {
    View view;
    TextView txtxemthemalbum;
    RecyclerView rcalbum;
    AlbumAdapter albumAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_albumhot,container,false);
        rcalbum = (RecyclerView) view.findViewById(R.id.recyclerAlbum);
        txtxemthemalbum = (TextView) view.findViewById(R.id.textxemthem);
        Getdata();
        return view;
    }

    private void Getdata() {
        Dataservice dataservice = APIservice.getService();
        Call<List<Album>> callback = dataservice.GetAlbumeveryday();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> albumArrayList = (ArrayList<Album>) response.body();
                albumAdapter = new AlbumAdapter(getActivity(),albumArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                rcalbum.setLayoutManager(linearLayoutManager);
                rcalbum.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
