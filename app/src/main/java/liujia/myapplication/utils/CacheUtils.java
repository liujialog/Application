package liujia.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by liujia on 19-3-4.
 * 作用 ： 缓存软件的一些参数 和 数据
 */

public class CacheUtils {



    /**
     * 得到缓存值
     * @param context 上下文
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        //TODO learn SharedPreferences http://www.runoob.com/w3cnote/android-tutorial-sharedpreferences.html
        SharedPreferences sharedPreferences = context.getSharedPreferences("liujia",Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }


}
