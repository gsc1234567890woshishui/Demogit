package views;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import org.zzgsc.com.demo_ch.R;
import java.util.List;
import top.wuhaojie.bthelper.BtHelperClient;
import top.wuhaojie.bthelper.Filter;
import top.wuhaojie.bthelper.MessageItem;
import top.wuhaojie.bthelper.OnSearchDeviceListener;
import top.wuhaojie.bthelper.OnSendMessageListener;
/**
 * Created by Administrator on 2016/10/22.
 */
public class TestView extends AppCompatActivity {
    private BtHelperClient btHelperClient;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testviews);
        btHelperClient = BtHelperClient.from(this);
    }
    public void conn(View view){
        ConnLy();
        SendData();

    }

    private void SendData() {
        MessageItem item = new MessageItem("Hello");
        btHelperClient.sendMessage("20:15:03:18:08:63", item, true, new OnSendMessageListener() {
            @Override
            public void onSuccess(int status, String response) {

            }

            @Override
            public void onConnectionLost(Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }

        });
    }
    private void ConnLy() {
        btHelperClient.searchDevices(new OnSearchDeviceListener() {
            @Override
            public void onStartDiscovery() {
                // Call before discovery devices
                Log.d("gsc", "onStartDiscovery()");

            }
            @Override
            public void onNewDeviceFounded(BluetoothDevice device) {
                // Call when found a new device
                Log.d("gsc", "new device: " + device.getName() + " " + device.getAddress());

            }

            @Override
            public void onSearchCompleted(List<BluetoothDevice> bondedList, List<BluetoothDevice> newList) {
                // Call when the discovery process completed
                Log.d("gsc", "SearchCompleted: bondedList" + bondedList.toString());
                Log.d("gsc", "SearchCompleted: newList" + newList.toString());
            }
            @Override
            public void onError(Exception e) {
                e.printStackTrace();

            }

        });
        btHelperClient.setFilter(new Filter() {
        @Override
        public boolean isCorrect(String response) {
            return response.trim().length() >= 5;
        }

    });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        btHelperClient.close();

    }
}
