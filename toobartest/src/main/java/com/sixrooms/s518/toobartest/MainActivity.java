package com.sixrooms.s518.toobartest;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.backdrop);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("哔哩哔哩");
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.inflateMenu(R.menu.sample_actions);

        setSupportActionBar(mToolbar);
        collapsingToolbar.setTitle("古词绝唱");
        mImageView.setImageResource(R.mipmap.haitun);

    }
}
