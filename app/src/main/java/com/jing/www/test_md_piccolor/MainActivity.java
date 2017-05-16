package com.jing.www.test_md_piccolor;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn)
    public void onClick() {
        //1.获取bitmap
        Drawable drawable = getResources().getDrawable(R.drawable.pre10);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        //2.palette异步获取
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                //3.获取颜色,鲜艳,鲜艳暗,鲜艳亮,柔和,柔和暗,柔和亮
                int color1 = palette.getVibrantColor(Color.BLACK);
                int color2 = palette.getDarkVibrantColor(Color.BLACK);
                int color3 = palette.getLightVibrantColor(Color.BLACK);
                int color4 = palette.getMutedColor(Color.BLACK);
                int color5 = palette.getDarkMutedColor(Color.BLACK);
                int color6 = palette.getLightMutedColor(Color.BLACK);

                //4.设置颜色
                tv1.setBackgroundColor(color1);
                tv2.setBackgroundColor(color2);
                tv3.setBackgroundColor(color3);
                tv4.setBackgroundColor(color4);
                tv5.setBackgroundColor(color5);
                tv6.setBackgroundColor(color6);

            }
        });
    }
}
