package com.keke.bannerviewpage;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.keke.banner.BannerAdapter;
import com.keke.banner.BannerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BannerView banner;
    private List<String> arrrar = new ArrayList<>();
    private List<Integer> listDrae = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inData();
    }

    private void inData() {
        arrrar.clear();
        for (int i = 0; i < 5; i++) {
            arrrar.add("数据");
            switch (i) {
                case 0:
                    listDrae.add(R.mipmap.ma_01);
                    break;
                case 1:
                    listDrae.add(R.mipmap.ma_02);
                    break;
                case 2:
                    listDrae.add(R.mipmap.ma_03);
                    break;
                case 3:
                    listDrae.add(R.mipmap.ma_04);
                    break;
                case 4:
                    listDrae.add(R.mipmap.ma_05);
                    break;
                case 5:
                    listDrae.add(R.mipmap.ma_06);
                    break;
            }

        }
        banner = ((BannerView) findViewById(R.id.banner_view));
        banner.setIndicatorGravity(1);
        banner.setManage(10, 10, 50);
        banner.setAdapter(arrrar);
        banner.setIndicationColor("#00ff00","#0000ff");
        banner.setOnloadBannerList(new BannerView.onLoadBannerImageLister() {
            @Override
            public void onLoadBanner(ImageView imageView, String url, int position) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                Glide.with(MainActivity.this).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fa4.att.hudong.com%2F27%2F67%2F01300000921826141299672233506.jpg&refer=http%3A%2F%2Fa4.att.hudong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612776257&t=309c06efe8a491e4f613589e1cedf61b")
                        .into(imageView);


            }
        });
//        banner.setAdapter(new BannerAdapter() {
//            @Override
//            public View getView(final int position, View contrtView) {
//                ImageView imageView = null;
//                if (contrtView == null) {
//
//                    imageView = new ImageView(MainActivity.this);
//                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//
//
//                } else {
//                    imageView = (ImageView) contrtView;
//                }
//                imageView.setImageResource(R.mipmap.banner2);
//                imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, "点击" + position, Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//
//                return imageView;
//            }
//
//            @Override
//            public int getContent() {
//                return arrrar.size();
//            }
//        });
        banner.setStartbanner();
    }


    public void banner(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                inData();
            }
        }, 100);


    }
}