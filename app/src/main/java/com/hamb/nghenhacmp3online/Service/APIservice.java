package com.hamb.nghenhacmp3online.Service;

public class APIservice {
    private static String base_url = "https://nphaa95.000webhostapp.com/sever/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
