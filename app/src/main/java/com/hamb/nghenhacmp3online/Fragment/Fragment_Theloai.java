package com.hamb.nghenhacmp3online.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hamb.nghenhacmp3online.Adapter.AlbumAdapter;
import com.hamb.nghenhacmp3online.Adapter.TheLoaiAdapter;
import com.hamb.nghenhacmp3online.Model.Album;
import com.hamb.nghenhacmp3online.Model.Theloai;
import com.hamb.nghenhacmp3online.R;
import com.hamb.nghenhacmp3online.Service.APIservice;
import com.hamb.nghenhacmp3online.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Theloai extends Fragment {
    View view;
    TextView txtxemthemtheloai;
    RecyclerView rctheloai;
    TheLoaiAdapter theLoaiAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_theloai,container,false);
        rctheloai = (RecyclerView) view.findViewById(R.id.recyclerTheloai);
        txtxemthemtheloai = (TextView) view.findViewById(R.id.textxemthemtheloai);
        Getdata();
        return view;
    }

    private void Getdata() {
        Dataservice dataservice = APIservice.getService();
        Call<List<Theloai>> callback = dataservice.GetTheLoai();
        callback.enqueue(new Callback<List<Theloai>>() {
            @Override
            public void onResponse(Call<List<Theloai>> call, Response<List<Theloai>> response) {
                ArrayList<Theloai> theloaiArrayList = (ArrayList<Theloai>) response.body();
                theLoaiAdapter = new TheLoaiAdapter(getActivity(),theloaiArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                rctheloai.setLayoutManager(linearLayoutManager);
                rctheloai.setAdapter(theLoaiAdapter);
            }

            @Override
            public void onFailure(Call<List<Theloai>> call, Throwable t) {

            }
        });
    }
}
