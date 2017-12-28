package com.bwie.frescolianxi;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main4Activity extends AppCompatActivity {

    @BindView(R.id.simpl4)
    SimpleDraweeView simpl4;
    @BindView(R.id.bt_gai)
    Button btGai;
    private Uri uri;
    private GenericDraweeHierarchyBuilder builder;

    /**
     * 添加网格
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);
        uri = Uri.parse("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1805078751,3320679762&fm=27&gp=0.jpg");
         builder=new GenericDraweeHierarchyBuilder(getResources());
    }

    @OnClick(R.id.bt_gai)
    public void onViewClicked() {
        Postprocessor postprocessor=new BasePostprocessor() {
            @Override
            public String getName() {
                return "postprocessor";
            }

            @Override
            public void process(Bitmap bitmap) {
                for (int x = 0; x < bitmap.getWidth(); x+=2) {
                    for (int y = 0; y < bitmap.getHeight(); y+=2) {
                        bitmap.setPixel(x, y, Color.GREEN);
                    }
                }
            }
        };
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(postprocessor)
                .build();

        PipelineDraweeController controller = (PipelineDraweeController)
                Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(simpl4.getController())
                        // other setters as you need
                        .build();
        simpl4.setController(controller);
    }
}
