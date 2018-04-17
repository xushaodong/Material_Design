package com.sixrooms.s518.drawerlayouttest;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.FragmentAdapter;
import fragment.FragmentAttention;
import fragment.FragmentFind;
import fragment.FragmentLive;
import fragment.FragmentRecommend;
import fragment.FragmentVideo;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    public TabLayout mTabLayout;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private ImageView mMoreImageView;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private FloatingActionButton mFloatingActionButton;

    private List<String> mTitleList = new ArrayList<String>();//页卡标题集合
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        initView();
        setView();
    }

    private void setView() {


        mTitleList.add("直播");
        mTitleList.add("推荐");
        mTitleList.add("番剧");
        mTitleList.add("分区");
        mTitleList.add("关注");
        mTitleList.add("发现");

        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(3)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(4)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(5)));

        //初始化ViewPager的数据集
        fragments.add(new FragmentLive());
        fragments.add(new FragmentRecommend());
        fragments.add(new FragmentVideo());
        fragments.add(new FragmentAttention());
        fragments.add(new FragmentFind());

        FragmentAdapter mAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, mTitleList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mViewPager.setOffscreenPageLimit(5);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式:固定不可滚动
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
//        mMoreImageView = (ImageView) findViewById(R.id.iv_main_more);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mNavigationView.setNavigationItemSelectedListener(this);
        mFloatingActionButton.setOnClickListener(this);
        //初始化ToolBar
//        mToolbar.inflateMenu(R.menu.base_toolbar_menu);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.mipmap.live_anchor);
        mToolbar.setTitle("哔哩哔哩动画");
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setOnMenuItemClickListener(this);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
//        mMoreImageView.setOnClickListener(this);

    }

    private void initData() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.base_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int menuItemId = item.getItemId();
        if (menuItemId == R.id.item_attention) {
            Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
        } else if (menuItemId == R.id.item_commend) {
            Toast.makeText(this, "点赞", Toast.LENGTH_SHORT).show();
        } else if (menuItemId == R.id.item_home) {
            Toast.makeText(this, "我的主页", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == mMoreImageView) {
            Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show();
        } else if (v == mFloatingActionButton) {
            Snackbar.make(mFloatingActionButton, "", Snackbar.LENGTH_LONG)
                    .setAction("六间房秀场", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "被点击了", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
        }

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        Snackbar.make(mFloatingActionButton, "", Snackbar.LENGTH_LONG)
                .setAction("哔哩哔哩显示", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "被点击了", Toast.LENGTH_SHORT).show();
                    }
                }).show();
        menuItem.setChecked(true);
        mDrawerLayout.closeDrawers();
        return true;
    }
}
