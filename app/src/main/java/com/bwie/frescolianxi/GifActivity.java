package com.bwie.frescolianxi;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GifActivity extends AppCompatActivity {

    @BindView(R.id.simpl_gif)
    SimpleDraweeView simplGif;
    @BindView(R.id.bt_gif)
    Button btGif;
    @BindView(R.id.bt_start)
    Button btStart;
    @BindView(R.id.bt_stop)
    Button btStop;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        ButterKnife.bind(this);
        uri=Uri.parse("http://img05.tooopen.com/products/20141215/EC17D785-1E06-F2C9-8A4B-4CBE9D0C8B08.gif");

    }

    @OnClick({R.id.bt_gif, R.id.bt_start, R.id.bt_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_gif:
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(false)
                        .build();
                simplGif.setController(controller);
                break;
            case R.id.bt_start:
                Animatable animatable = simplGif.getController().getAnimatable();
                if (animatable != null) {
                    animatable.start();
                    // later
                }

                break;
            case R.id.bt_stop:
                Animatable animatable2 = simplGif.getController().getAnimatable();
                if (animatable2 != null) {
                    animatable2.stop();
                    // later
                }
                break;
        }
    }
}
