package nets;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/**
 * Created by Administrator on 2016/10/22.
 */
public abstract class OkHttpUtils {
    public abstract void OnNetSucess(Response response);
    public abstract void OnNetFail(String response);
    private static OkHttpClient okHttpClient=new OkHttpClient();
    public synchronized static OkHttpClient getInstance(){
        if (okHttpClient==null){
            okHttpClient=new OkHttpClient();
        }
        return okHttpClient;
    }
    /**
     * @param url
     * get 方法
     */
    public void DoGet(String url){
        Request.Builder builder=new Request.Builder().url(url);
        builder.method("GET",null);
        final Request request=builder.build();
        Call call = getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                OnNetFail(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                OnNetSucess( response);
            }
        });
    }

    /**
     * @param url
     * @param map
     * post请求
     */
    public void DoPost(String url, Map<String,String> map){
        FormBody.Builder builder = new FormBody.Builder();
        for(Map.Entry<String,String> m:map.entrySet()){
            String key = m.getKey();
            String value = m.getValue();
            builder.add(key,value);
        }
        RequestBody body=builder.build();
        Request r=new Request.Builder().url(url).post(body).build();
        Call call = getInstance().newCall(r);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                OnNetFail(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                OnNetSucess(response);
            }
        });
    }
}
