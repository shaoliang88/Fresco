package com.bwie.frescolianxi;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main7Activity extends AppCompatActivity {

    @BindView(R.id.bt_gai2)
    Button btGai2;
    @BindView(R.id.line1)
    LinearLayout line1;
    private Uri uri;

    /**
     * 动态展示图片(代码里添加控件)
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ButterKnife.bind(this);
        uri = Uri.parse("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1805078751,3320679762&fm=27&gp=0.jpg");

    }

    @OnClick(R.id.bt_gai2)
    public void onViewClicked() {
        SimpleDraweeView simpl = new SimpleDraweeView(this);
        //固定的宽高比
        simpl.setAspectRatio(0.5f);
       ImageRequest request=ImageRequestBuilder.newBuilderWithSource(uri)
               .build();
        PipelineDraweeController controller= (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(simpl.getController())//内存优化
                .build();
        simpl.setController(controller);
        line1.addView(simpl);
    }
}
