package com.bwie.frescolianxi;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main6Activity extends AppCompatActivity {

    @BindView(R.id.simpl6)
    SimpleDraweeView simpl6;
    @BindView(R.id.bt_gai2)
    Button btGai2;
    private Uri uri;

    /**
     * 修改图片占用大小
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ButterKnife.bind(this);
        uri = Uri.parse("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1805078751,3320679762&fm=27&gp=0.jpg");
    }

    @OnClick(R.id.bt_gai2)
    public void onViewClicked() {
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
             //重新设置图片的宽高
                .setResizeOptions(new ResizeOptions(200,200))
                .build();
        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setOldController(simpl6.getController())
                .setImageRequest(request)
                .build();
        simpl6.setController(controller);
    }
}
