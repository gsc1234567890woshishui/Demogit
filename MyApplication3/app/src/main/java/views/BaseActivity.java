package views;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
/**
 * Created by Administrator on 2016/10/31.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayId());
        initData();
    }
    protected abstract void initData();
    protected abstract int getLayId();
}
