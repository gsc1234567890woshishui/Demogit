package nets;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import org.zzgsc.com.demo_ch.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
/**
 * Created by Administrator on 2016/10/22.
 */
public class TestNets extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nets);
    }
    public void get(View view){
//        OkHttpClient okHttpClient=new OkHttpClient();
//        Request request=new Request.Builder().url("http://www.baidu.com").build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String string = response.body().string();
//                System.out.println("-------main--"+Thread.currentThread().getName());
//                System.out.println("------ok---"+string);
//            }
//        });
//        OkHttpUtils utils=new OkHttpUtils() {
//            @Override
//            public void OnNetSucess(Response response) {
//                try {
//                    System.out.println("---gsc-"+response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void OnNetFail(String response) {
//                System.out.println("---gsc-"+response);
//            }
//        };
//        utils.DoGet("http://www.baidu.com");
        OkHttpUtils okHttpUtils=new OkHttpUtils() {
            @Override
            public void OnNetSucess(Response response) {
                try {
                    System.out.println("----------gsc---"+response.body().string());
                    System.out.println("----------gsc---"+Thread.currentThread().getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void OnNetFail(String response) {
                System.out.println("----------gsc---"+response);
            }
        };
        Map<String,String> map= new HashMap<>();
        map.put("name","宋殿坤");
        //412827198905224016
        map.put("percard","412827198905224016");
        map.put("cxtype","11");
        okHttpUtils.DoPost("http://203.171.237.153:8080/001/f/person/info",map);
    }
}
