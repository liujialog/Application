package liujia.myapplication.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import liujia.myapplication.R;

public class GuideActivity extends AppCompatActivity {

    //TODO GuideActivity

    private ViewPager viewPager ;
    private Button btn_start_main ;
    private LinearLayout point_group ;

    private ArrayList<ImageView> imageViews ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewPager= findViewById(R.id.viewpager);
        btn_start_main= findViewById(R.id.btn_start_main);
        point_group= findViewById(R.id.point_group);

        //准备数据
        int[] ids = new int[]{
                R.drawable.first,
                R.drawable.second,
                R.drawable.third
        };
        imageViews = new ArrayList<>();
        for (int i=0 ; i<ids.length ;i++){
            ImageView imageView = new ImageView(this);
            //设置背景
            imageView.setBackgroundResource(ids[i]);
            //添加到集合中
            imageViews.add(imageView);
        }

        //设置ViewPager的适配器
        viewPager.setAdapter(new MyPagerAdapter());
    }

    class MyPagerAdapter extends PagerAdapter{

        /**
         * 返回数据的总个数
         * @return  imageViews.size()
         */
        @Override
        public int getCount() {
            return imageViews.size();
        }

        /**
         * 判断
         * @param view 当前创建的视图
         * @param object 下面instantiateItem 返回的结果值
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == imageViews.get(Integer.parseInt((String)object));
//            return view == object ;
        }

        /**
         * 作用，getView
         * @param container ViewPager
         * @param position 要创建页面的的位置
         * @return 返回要创建页面与当前页面的关系值
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imageViews.get(position);
            //添加到容器中
            container.addView(imageView);
            return imageView;
//            return position;
        }

        /**
         * 销毁页面
         * @param container ViewPager
         * @param position 要销毁页面的位置
         * @param object  要销毁的页面
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
}
