package views;

import android.app.Application;

import com.baidu.apistore.sdk.ApiStoreSDK;

/**
 * Created by Administrator on 2016/10/22.
 */

public class MyApp extends Application {
    public static final String APPKEY="392aaf68a9e2a91f79eb11bf9860f7ed";
    //apikey
    @Override
    public void onCreate() {
        super.onCreate();
             // TODO 您的其他初始化流程
            ApiStoreSDK.init(this, APPKEY);
            super.onCreate();

    }
}
