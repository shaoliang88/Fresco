package com.bwie.frescolianxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TitleActivity extends AppCompatActivity {

    @BindView(R.id.bt_fresco_spimg)
    Button btFrescoSpimg;
    @BindView(R.id.bt_fresco_crop)
    Button btFrescoCrop;
    @BindView(R.id.bt_fresco_circleAndCorner)
    Button btFrescoCircleAndCorner;
    @BindView(R.id.bt_fresco_jpeg)
    Button btFrescoJpeg;
    @BindView(R.id.bt_fresco_gif)
    Button btFrescoGif;
    @BindView(R.id.bt_fresco_multi)
    Button btFrescoMulti;
    @BindView(R.id.bt_fresco_listener)
    Button btFrescoListener;
    @BindView(R.id.bt_fresco_resize)
    Button btFrescoResize;
    @BindView(R.id.bt_fresco_modifyImg)
    Button btFrescoModifyImg;
    @BindView(R.id.bt_fresco_autoSizeImg)
    Button btFrescoAutoSizeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.bt_fresco_spimg, R.id.bt_fresco_crop, R.id.bt_fresco_circleAndCorner, R.id.bt_fresco_jpeg, R.id.bt_fresco_gif, R.id.bt_fresco_multi, R.id.bt_fresco_listener, R.id.bt_fresco_resize, R.id.bt_fresco_modifyImg, R.id.bt_fresco_autoSizeImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_fresco_spimg:
                //进度条
                Intent in=new Intent(TitleActivity.this,MainActivity.class);
                startActivity(in);
                break;
            case R.id.bt_fresco_crop:
                //缩放
                Intent in2=new Intent(TitleActivity.this,Main8Activity.class);
                startActivity(in2);
                break;
            case R.id.bt_fresco_circleAndCorner:
                //圆角圆圈切换
                Intent in3=new Intent(TitleActivity.this,Main2Activity.class);
                startActivity(in3);
                break;
            case R.id.bt_fresco_jpeg:
                //渐进式
                Intent in4=new Intent(TitleActivity.this,Main3Activity.class);
                startActivity(in4);
                break;
            case R.id.bt_fresco_gif:
                //动态图
                Intent in5=new Intent(TitleActivity.this,GifActivity.class);
                startActivity(in5);
                break;
            case R.id.bt_fresco_multi:
                //缩略图
                Intent in6=new Intent(TitleActivity.this,Main9Activity.class);
                startActivity(in6);
                break;
            case R.id.bt_fresco_listener:
                //图片监听
                Intent in7=new Intent(TitleActivity.this,Main5Activity.class);
                startActivity(in7);
                break;
            case R.id.bt_fresco_resize:
                //修改图片占用大小
                Intent in8=new Intent(TitleActivity.this,Main6Activity.class);
                startActivity(in8);
                break;
            case R.id.bt_fresco_modifyImg:
                //添加网格
                Intent in9=new Intent(TitleActivity.this,Main4Activity.class);
                startActivity(in9);
                break;
            case R.id.bt_fresco_autoSizeImg:
                //动态展示图片(代码里添加控件)
                Intent in10=new Intent(TitleActivity.this,Main7Activity.class);
                startActivity(in10);
                break;
        }
    }
}
