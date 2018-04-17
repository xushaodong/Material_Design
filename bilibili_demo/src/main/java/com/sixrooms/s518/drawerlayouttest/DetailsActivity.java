package com.sixrooms.s518.drawerlayouttest;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by xushaodong on 2016/4/12.
 */
public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private CollapsingToolbarLayout collapsingToolbar;
    private ImageView mImageView;
    private Toolbar mToolbar;
    private FloatingActionButton floatingActionButton;
    private String jpgurl = "http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        loadBackdrop();
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingab);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_tt);
//        mToolbar.inflateMenu(R.menu.sample_actions);
        setSupportActionBar(mToolbar);
//        mToolbar.setOnMenuItemClickListener(this);
        collapsingToolbar.setTitle("古词绝唱");
        floatingActionButton.setOnClickListener(this);

    }

    private void loadBackdrop() {
        mImageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(jpgurl);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == floatingActionButton) {
            Snackbar.make(floatingActionButton, "我失骄杨君失柳", Snackbar.LENGTH_LONG)
                    .setAction("经典诗词", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(DetailsActivity.this, "被点击了", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
        }
    }

}
