package com.shanghui.meixian.http.inter;


import com.shanghui.meixian.config.Contance;
import com.shanghui.meixian.http.bean.InfoBean;
import com.shanghui.meixian.http.bean.WeatherInfoBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("weather")
    Call<InfoBean> loadeather(@Query("cityname") String cityname, @Query("key") String apiKey);


    @GET(Contance.getWeather)
    Call<WeatherInfoBean> getWeather(@Query("location") String location, @Query("output") String output, @Query("coord_type") String coord_type, @Query("ak") String ak);


}
