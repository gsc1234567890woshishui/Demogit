package views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.zzgsc.com.demo_ch.R;
/**
 * Created by Administrator on 2016/10/22.
 */
public class TestApi extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testviews);
    }
    public void conn(View view){
        Picasso.with(this).load("http://inews.gtimg.com/newsapp_ls/0/700251736_300240/0").into((ImageView) findViewById(R.id.iv));
        //GetData();
    }
    private void GetData() {
        Parameters para = new Parameters();
        para.put("cityname", "郑州");
        ApiStoreSDK.execute("http://apis.baidu.com/apistore/weatherservice/cityname",
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {
                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("gsc", "onSuccess"+responseString);
                        ParseJson(responseString);
                    }
                    @Override
                    public void onComplete() {
                        Log.i("gsc", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        Log.i("gsc", "onError, status: " + status);
                        Log.i("gsc", "errMsg: " + (e == null ? "" : e.getMessage()));

                    }

                });
    }

    /**
     * @param responseString
     */
    private void ParseJson(String responseString) {
        Gson gson=new Gson();
        D d = gson.fromJson(responseString, D.class);
        D.RetDataBean retData = d.getRetData();
        String city = retData.getCity();
        Log.i("gsc","---city-"+city);
        String weather = retData.getWeather();
        String s = Utils.decodeUnicode(weather);
        Log.i("gsc","-- weather--"+s);
        String wd = retData.getWD();
        String s1 = Utils.decodeUnicode(wd);
        Log.i("gsc","---wd--"+s1);
        String ws = retData.getWS();
        String s2 = Utils.decodeUnicode(ws);
        Log.i("gsc","--ws--"+s2);
    }
}
