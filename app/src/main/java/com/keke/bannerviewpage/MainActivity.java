package com.keke.bannerviewpage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        banner.setAdapter(arrrar);
        banner.setOnloadBannerList(new BannerView.onLoadBannerImageLister() {
            @Override
            public void onLoadBanner(ImageView imageView, String url, int position) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                imageView.setImageResource(R.mipmap.banner2);
                if (position >= 5) {
                    position = position - 5;
                }
                imageView.setImageResource(listDrae.get(position));


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
        inData();


    }
}