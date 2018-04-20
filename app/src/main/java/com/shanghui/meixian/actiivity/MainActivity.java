package com.shanghui.meixian.actiivity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.shanghui.meixian.R;
import com.shanghui.meixian.http.RetrofitUtil;
import com.shanghui.meixian.http.bean.InfoBean;
import com.shanghui.meixian.http.inter.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.botton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
//                Intent intent=new Intent(MainActivity.this, SprinTestActivity.class);
                Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    public void request() {

        ApiService service = RetrofitUtil.getInstance().create(ApiService.class);
        Call<InfoBean> call = service.loadeather("shenz", "hufh");

        call.enqueue(new Callback<InfoBean>() {
            @Override
            public void onResponse(Call<InfoBean> call, Response<InfoBean> response) {

            }

            @Override
            public void onFailure(Call<InfoBean> call, Throwable t) {

            }
        });


    }
}
