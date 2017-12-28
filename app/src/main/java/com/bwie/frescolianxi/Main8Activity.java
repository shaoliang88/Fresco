package com.bwie.frescolianxi;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main8Activity extends AppCompatActivity {

    @BindView(R.id.simpl8)
    SimpleDraweeView simpl8;
    @BindView(R.id.bt_center)
    Button btCenter;
    @BindView(R.id.bt_group)
    Button btGroup;
    @BindView(R.id.bt_scroup)
    Button btScroup;
    @BindView(R.id.bt_inside)
    Button btInside;
    @BindView(R.id.bt_nter)
    Button btNter;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.bt_start)
    Button btStart;
    @BindView(R.id.bt_end)
    Button btEnd;
    @BindView(R.id.bt_XY)
    Button btXY;
    private Uri uri;
    private GenericDraweeHierarchyBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        ButterKnife.bind(this);
        uri = Uri.parse("http://img4q.duitang.com/uploads/item/201305/20/20130520115416_VrUUR.jpeg");
        builder = new GenericDraweeHierarchyBuilder(getResources());
    }

    @OnClick({ R.id.tv, R.id.bt_center, R.id.bt_group, R.id.bt_scroup, R.id.bt_inside, R.id.bt_start, R.id.bt_end, R.id.bt_XY, R.id.bt_nter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_center:
                tv.setText("居中，无缩放");
                GenericDraweeHierarchy center = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER).build();
                simpl8.setHierarchy(center);
                simpl8.setImageURI(uri);
                break;
            case R.id.bt_group:
                tv.setText("保持宽高比缩小或放大，使得两边都大于或等于显示边界。居中显示");
                GenericDraweeHierarchy group=builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build();
                simpl8.setHierarchy(group);
                simpl8.setImageURI(uri);
                break;
            case R.id.bt_scroup:
                tv.setText("同centerCrop, 但居中点不是中点，而是指定的某个点");
                PointF point = new PointF(6,6);
                GenericDraweeHierarchy scroup = builder.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP).setActualImageFocusPoint(point).build();
                simpl8.setHierarchy(scroup);
                simpl8.setImageURI(uri);
                break;
            case R.id.bt_inside:
                tv.setText("使两边都在显示边界内，居中显示。如果图尺寸大于显示边界，则保持长宽比缩小图片");
                GenericDraweeHierarchy inside = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build();
                simpl8.setHierarchy(inside);
                simpl8.setImageURI(uri);
                break;
            case R.id.bt_start:
                tv.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界左上对齐");
                GenericDraweeHierarchy start = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).build();
                simpl8.setHierarchy(start);
                simpl8.setImageURI(uri);
                break;
            case R.id.bt_end:
                tv.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界右下对齐");
                GenericDraweeHierarchy end = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_END).build();
                simpl8.setHierarchy(end);
                simpl8.setImageURI(uri);
                break;
            case R.id.bt_XY:
                tv.setText("不保持宽高比，填充满显示边界");
                GenericDraweeHierarchy xy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                simpl8.setHierarchy(xy);
                simpl8.setImageURI(uri);
                break;
            case R.id.bt_nter:
                tv.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内。居中显示");
                GenericDraweeHierarchy nter = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
                simpl8.setHierarchy(nter);
                simpl8.setImageURI(uri);
                break;
        }
    }
}
