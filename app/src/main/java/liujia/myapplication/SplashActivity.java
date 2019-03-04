package liujia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import liujia.myapplication.activity.GuideActivity;
import liujia.myapplication.utils.CacheUtils;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RelativeLayout splash_root = findViewById(R.id.splash_root); //


        //TODO learn Animation http://www.runoob.com/w3cnote/android-tutorial-valueanimator.html
        //渐变动画，缩放动画，旋转动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1); //Animation 动画 alphaAnimation 应该是阿尔法通道的动画 , 0-1 从看不见到看得见
//        alphaAnimation.setDuration(2000); // duration 持续播放时间（播放时长） ms
        alphaAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
//        scaleAnimation.setDuration(2000);// scale  规模 =size  怎么就成了缩放动画了...
        scaleAnimation.setFillAfter(true);

        RotateAnimation rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
//        rotateAnimation.setDuration(2000);
        rotateAnimation.setFillAfter(true);

        AnimationSet set = new AnimationSet(false) ;
        //添加三个动画的没有顺序,便于同事播放
        set.addAnimation(alphaAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(rotateAnimation);
        set.setDuration(2000); //在set中设置时间 取代上面三行代码

        splash_root.startAnimation(set);

        set.setAnimationListener(new MyAnimationListener());
    }

    class MyAnimationListener implements Animation.AnimationListener {

        private static final String START_MAIN = "start_main";

        /**
         * 动画开始播放  回调该方法
         * @param animation
         */
        @Override
        public void onAnimationStart(Animation animation) {

        }

        /**
         * 动画结束播放  回调该方法
         * @param animation
         */
        @Override
        public void onAnimationEnd(Animation animation) {
            //判断是否进入过主页面
            boolean isStartMain = CacheUtils.getBoolean(SplashActivity.this,START_MAIN); // "start_main"  the shortcuts key  ctrl+alt+c -> public static final String START_MAIN = "start_main";


            if (isStartMain){//如果进入过主页面 则直接进入主页面

            }else{ //如果没有过主页面 则直接进入引导界面
                //TODO learn Intent http://www.runoob.com/w3cnote/android-tutorial-intent-base.html
                Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
                startActivity(intent);
            }


            finish();//关闭Splash页面

//            Toast.makeText(SplashActivity.this, "动画播放完成", Toast.LENGTH_SHORT).show();
            //TODO learn Toast http://www.runoob.com/w3cnote/android-tutorial-toast.html
        }
        /**
         * 动画循环播放  回调该方法
         * @param animation
         */
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}
