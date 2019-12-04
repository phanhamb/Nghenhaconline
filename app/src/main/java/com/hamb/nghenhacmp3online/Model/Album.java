package com.hamb.nghenhacmp3online.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

@SerializedName("Idalbum")
@Expose
private String idalbum;
@SerializedName("Tenalbum")
@Expose
private String tenalbum;
@SerializedName("Tencasi")
@Expose
private String tencasi;
@SerializedName("Hinhalbum")
@Expose
private String hinhalbum;

public String getIdalbum() {
return idalbum;
}

public void setIdalbum(String idalbum) {
this.idalbum = idalbum;
}

public String getTenalbum() {
return tenalbum;
}

public void setTenalbum(String tenalbum) {
this.tenalbum = tenalbum;
}

public String getTencasi() {
return tencasi;
}

public void setTencasi(String tencasi) {
this.tencasi = tencasi;
}

public String getHinhalbum() {
return hinhalbum;
}

public void setHinhalbum(String hinhalbum) {
this.hinhalbum = hinhalbum;
}

}