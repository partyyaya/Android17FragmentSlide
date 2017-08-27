package tw.ming.app.helloworid.myfragmentslide;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private ArrayList<View> views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        initViewPager();
    }
    private void initViewPager(){
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);

        View view0 = inflater.inflate(R.layout.pag3,null);
        View view1 = inflater.inflate(R.layout.pag1,null);
        View view2 = inflater.inflate(R.layout.pag2,null);
        View view3 = inflater.inflate(R.layout.pag3,null);
        View view4 = inflater.inflate(R.layout.pag3,null);
        views.add(view0);views.add(view4);views.add(view1);views.add(view2);views.add(view3);

        pager.setAdapter(new MyPagerAdapter());
        pager.setOnPageChangeListener(new MyPagerListener());
        pager.setCurrentItem(1);
    }

    private class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return  view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            pager.addView(view);
            Log.i("ming","add:"+position);
            Log.i("ming","pager child:"+pager.getChildCount());
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            Log.i("ming","remove:"+position);
            Log.i("ming","pager child:"+pager.getChildCount());
            pager.removeView(views.get(position));
        }
    }

    private class MyPagerListener extends  ViewPager.SimpleOnPageChangeListener{
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if(position ==0){
                pager.setCurrentItem(1);
            }else if(position ==4){
                pager.setCurrentItem(3);
            }
        }
    }
}
