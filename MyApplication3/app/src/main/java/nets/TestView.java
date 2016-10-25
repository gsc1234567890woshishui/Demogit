package nets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.gigamole.infinitecycleviewpager.OnInfiniteCyclePageTransformListener;
import org.zzgsc.com.demo_ch.R;
/**
 * Created by Administrator on 2016/10/25.
 */
public class TestView extends AppCompatActivity implements OnInfiniteCyclePageTransformListener {
    private HorizontalInfiniteCycleViewPager vp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t);
        vp= (HorizontalInfiniteCycleViewPager) findViewById(R.id.vp);
        vp.setAdapter(new MyAdapter());
       vp.setScrollDuration(500);
        vp.setMediumScaled(true);
        vp.setMaxPageScale(0.8F);
       vp.setMinPageScale(0.5F);
       vp.setCenterPageScaleOffset(30.0F);
       vp.setMinPageScaleOffset(5.0F);
        vp.setOnInfiniteCyclePageTransformListener(this);
    }

    @Override
    public void onPreTransform(View page, float position) {
        System.out.println("onPreTransform"+position);
    }

    @Override
    public void onPostTransform(View page, float position) {
        System.out.println(" onPostTransform"+position);
    }
    class MyAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            ImageView imageView=new ImageView(container.getContext());
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("点击"+position);
                }
            });
            imageView.setBackgroundResource(R.drawable.ic_launcher);
            container.addView(imageView);
            return imageView;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView((View) object);
        }
    }
}
