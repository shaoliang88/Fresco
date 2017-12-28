package com.bwie.frescolianxi;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 圆角圆圈切换
 */
public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.simpl2)
    SimpleDraweeView simpl2;
    @BindView(R.id.bt_yuan)
    Button btYuan;
    @BindView(R.id.bt_jiao)
    Button btJiao;
    private Uri uri;

    private RoundingParams parames;
    private GenericDraweeHierarchyBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        uri = Uri.parse("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1805078751,3320679762&fm=27&gp=0.jpg");
         builder=new GenericDraweeHierarchyBuilder(getResources());
        simpl2.setImageURI(uri);
    }

    @OnClick({R.id.bt_yuan, R.id.bt_jiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_yuan:
                RoundingParams params=RoundingParams.asCircle();
                GenericDraweeHierarchy hierarchy = builder.setRoundingParams(parames).build();
                simpl2.setHierarchy(hierarchy);
                simpl2.setImageURI(uri);
                break;
            case R.id.bt_jiao:
                parames = RoundingParams.fromCornersRadius(30f);
                GenericDraweeHierarchy hierarchy2 = builder.setRoundingParams(parames).build();
                simpl2.setHierarchy(hierarchy2);
                simpl2.setImageURI(uri);
                break;
        }
    }
}
