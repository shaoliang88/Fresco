package com.bwie.frescolianxi;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main5Activity extends AppCompatActivity {

    @BindView(R.id.simpl5)
    SimpleDraweeView simpl5;
    @BindView(R.id.bt_gai)
    Button btGai;
    @BindView(R.id.tv)
    TextView tv;
    private Uri uri;
    private GenericDraweeHierarchyBuilder builder;

    /**
     * 图片监听
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ButterKnife.bind(this);
        uri = Uri.parse("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1805078751,3320679762&fm=27&gp=0.jpg");
        builder = new GenericDraweeHierarchyBuilder(getResources());
    }

    @OnClick(R.id.bt_gai)
    public void onViewClicked() {
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>(){
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
               //判断图片信息是空时
                if (imageInfo==null){
                    return;
                }
                //获取图片的详细信息
                QualityInfo info=imageInfo.getQualityInfo();
                tv.setText("宽"+imageInfo.getWidth()+"高"+imageInfo.getHeight()+"等级"+info.getQuality()+"图片是否完全显示"+info.isOfFullQuality()+"图片的效果是否完全显示"+info.isOfGoodEnoughQuality());
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
                tv.setText("加载失败"+id);
            }
        };
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setControllerListener(controllerListener)
                .setUri(uri)
                // other setters
                .build();
        simpl5.setController(controller);
    }
}
