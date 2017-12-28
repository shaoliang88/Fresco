package com.bwie.frescolianxi;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 进度条
 */
public class MainActivity extends AppCompatActivity {

    private Button bt;
    private SimpleDraweeView simpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         bt= (Button) findViewById(R.id.bt);
         simpl= (SimpleDraweeView) findViewById(R.id.simpl);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1805078751,3320679762&fm=27&gp=0.jpg");
                GenericDraweeHierarchyBuilder builder=new GenericDraweeHierarchyBuilder(getResources());
                GenericDraweeHierarchy hierarchy=builder.setProgressBarImage(new ProgressBarDrawable()).build();
                simpl.setHierarchy(hierarchy);
                simpl.setImageURI(uri);
            }
        });
    }
}
