package com.hamb.nghenhacmp3online.Service;

import com.hamb.nghenhacmp3online.Model.Album;
import com.hamb.nghenhacmp3online.Model.Baihat;
import com.hamb.nghenhacmp3online.Model.Playlist;
import com.hamb.nghenhacmp3online.Model.Theloai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("playlisteveryday.php")
    Call<List<Playlist>> GetPlaylisteveryday();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumeveryday();

    @GET("baihatyeuthich.php")
    Call<List<Baihat>> GetBaihatyeuthich();

    @GET("chudevatheloaiforday.php")
    Call<List<Theloai>> GetTheLoai();
}
