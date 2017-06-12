package com.example.naveen.home;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener,NavigationView.OnNavigationItemSelectedListener {
    ViewPager header1;
    private LinearLayout dotsLayout;
    private int dotsCount;
    private TextView[] dots;
    ActionBarDrawerToggle toggle;
    //	page change listener

    OnPageChangeListener viewPagerPageChangeListener = new OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < dotsCount; i++) {
                dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            }
            dots[position].setTextColor(getResources().getColor(android.R.color.black));
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
    private ViewPager viewPager,viewPager2;
    private MyViewPagerAdapter myViewPagerAdapter;
    private ArrayList<Integer> listOfItems;
    private ArrayList<String> names;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initViews();
        setViewPagerItemsWithAdapter();
        setUiPageViewController();
        viewPager2 = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager2);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabTextColors(Color.parseColor("#CCCCCC"),Color.parseColor("#FF0000"));

        tabLayout.setupWithViewPager(viewPager2);
     setupTabIcons();


    }
    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("VIDEOS");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.custom_video, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);


        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("IMAGES");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.custom_image, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);
        tabLayout.setTabTextColors(Color.parseColor("#CCCCCC"),Color.parseColor("#FF0000"));
        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("MILESTONE");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.custom_mile, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
        tabLayout.setTabTextColors(Color.parseColor("#CCCCCC"),Color.parseColor("#FF0000"));
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VideoCap(), "VIDEOS");
        adapter.addFragment(new ImagesCap(), "IMAGES");
        adapter.addFragment(new MileStone(), "MILESTONE");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



    @Override
    protected void onResume() {

        super.onResume();

    }
    private void setUiPageViewController() {
        // TODO Auto-generated method stub
        LinearLayout dotsLayout = (LinearLayout)findViewById(R.id.viewPagerCountDots);
        dotsCount = myViewPagerAdapter.getCount();
        dots = new TextView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            dotsLayout.addView(dots[i]);
        }
    }

    private void setViewPagerItemsWithAdapter() {
        // TODO Auto-generated method stub

        myViewPagerAdapter = new MyViewPagerAdapter(listOfItems,names);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(viewPagerPageChangeListener);
    }

    private void initViews() {
        // TODO Auto-generated method stub

        viewPager = (ViewPager)findViewById(R.id.viewPager);

        listOfItems = new ArrayList<>();
        names=new ArrayList<>();
        listOfItems.add(R.drawable.music);
        listOfItems.add(R.drawable.music);
        listOfItems.add(R.drawable.music);
        listOfItems.add(R.drawable.music);
        listOfItems.add(R.drawable.music);
        names.add("Inside Out Animation, Kids & Family");
        names.add("Inside Out Animation, Kids & Family");
        names.add("Inside Out Animation, Kids & Family");
        names.add("Inside Out Animation, Kids & Family");
        names.add("Inside Out Animation, Kids & Family");

    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    public class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;
        private ArrayList<Integer> items;
        ArrayList<String> name;

        public MyViewPagerAdapter(ArrayList<Integer> listOfItems,ArrayList<String> name) {
            this.items = listOfItems;
            this.name=name;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.view_pager_item, container, false);
            ImageView tv = (ImageView) view.findViewById(R.id.imageView1);
            tv.setImageResource(listOfItems.get(position));
            TextView tv1 = (TextView) view.findViewById(R.id.text12);
            tv1.setText(names.get(position));
            ((ViewPager) container).addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }




        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            ((ViewPager) container).removeView(view);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
