package com.bwie.frescolianxi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main9Activity extends AppCompatActivity {

    @BindView(R.id.simpl9)
    SimpleDraweeView simpl9;
    @BindView(R.id.bt_suo)
    Button btSuo;
    @BindView(R.id.bt_fu)
    Button btFu;
    @BindView(R.id.bt_pin)
    Button btPin;
    private Uri uri;
    private Uri lowUri;
    private Uri highUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        ButterKnife.bind(this);
         lowUri = Uri.parse("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3081068370,3266405581&fm=27&gp=0.jpg");
         highUri = Uri.parse("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1805078751,3320679762&fm=27&gp=0.jpg");
    }

    @OnClick({R.id.bt_suo, R.id.bt_fu, R.id.bt_pin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_suo:
                Uri highUri = Uri.parse("http://img5.duitang.com/uploads/item/201312/03/20131203153823_Y4y8F.jpeg");
 // 控制加载图片
                DraweeController controller = Fresco.newDraweeControllerBuilder()
//一开始加载一个低分辨率的URL
                        .setLowResImageRequest(ImageRequest.fromUri(lowUri))
//然后加载一个高分辨率的URL,你真正要加载的图片
                        .setImageRequest(ImageRequest.fromUri(highUri))
                        .build();
// 加载图片
                simpl9.setController(controller);
                break;
            case R.id.bt_fu:
                // 本地缩略图预览
// 图片地址,参数1.File对象, 从手机手机SD卡里加载一张图片
                Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() +"/shuaige.jpg"));
// 加载图片的请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
//开启缩略图预览模式
                        .setLocalThumbnailPreviewsEnabled(true)
                        .build();
// 控制图片的加载
                DraweeController preview = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .build();
// 加载图片
                simpl9.setController(preview);
                break;
            case R.id.bt_pin:
                Uri uri1 = Uri.fromFile(new File(Environment.getExternalStorageDirectory()+"/shuaige.jpg"));
//图片的网址
                Uri uri2 = Uri.parse("http://img5.duitang.com/uploads/item/201312/03/20131203153823_Y4y8F.jpeg");
//创建ImageRequest对象,将其放入ImageRequest[]数组中.
                ImageRequest request1 = ImageRequest.fromUri(uri1);
                ImageRequest request2 = ImageRequest.fromUri(uri2);
                ImageRequest[] requests = {request1, request2};
// 控制加载图片
                DraweeController reuse = Fresco.newDraweeControllerBuilder()
//设置加载图片的顺序.参数ImageRequest[]数组
                        .setFirstAvailableImageRequests(requests)
                        .setOldController(simpl9.getController())
                        .build();
// 加载图片
                simpl9.setController(reuse);
                break;
        }
    }
}
