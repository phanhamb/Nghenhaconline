package com.hamb.nghenhacmp3online.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hamb.nghenhacmp3online.Adapter.AdapterBaihatyeuthich;
import com.hamb.nghenhacmp3online.Model.Album;
import com.hamb.nghenhacmp3online.Model.Baihat;
import com.hamb.nghenhacmp3online.R;
import com.hamb.nghenhacmp3online.Service.APIservice;
import com.hamb.nghenhacmp3online.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class Fragment_Baihatyeuthich extends Fragment {
    View view;
    RecyclerView rcbaihatyeuthich;
    AdapterBaihatyeuthich adapterBaihatyeuthich;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihatyeuthich,container,false);
        rcbaihatyeuthich = view.findViewById(R.id.recyclerBaihatyeuthich);
        Getdata();
        return view;
    }

    private void Getdata() {
        Dataservice dataservice = APIservice.getService();
        Call<List<Baihat>> callback = dataservice.GetBaihatyeuthich();
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> baihatArrayList = (ArrayList<Baihat>) response.body();
                adapterBaihatyeuthich = new AdapterBaihatyeuthich(getActivity(),baihatArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                rcbaihatyeuthich.setLayoutManager(linearLayoutManager);
                rcbaihatyeuthich.setAdapter(adapterBaihatyeuthich);

            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }
}
