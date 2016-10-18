package org.zzgsc.com.demo_ch;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.ViewGroup;

import com.yanzhenjie.recyclerview.swipe.Closeable;
import com.yanzhenjie.recyclerview.swipe.OnSwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yanzhenjie.recyclerview.swipe.touch.OnItemMoveListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.rv)
    SwipeMenuRecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        rv.setLayoutManager(new LinearLayoutManager(this));
      //  String[] strs={"http://h.hiphotos.baidu.com/image/h%3D200/sign=b02f687c8a26cffc762ab8b289004a7d/42166d224f4a20a44149222298529822730ed0fb.jpg","http://h.hiphotos.baidu.com/image/h%3D200/sign=b02f687c8a26cffc762ab8b289004a7d/42166d224f4a20a44149222298529822730ed0fb.jpg","http://h.hiphotos.baidu.com/image/h%3D200/sign=b02f687c8a26cffc762ab8b289004a7d/42166d224f4a20a44149222298529822730ed0fb.jpg"};

        String[] strs={"B","C","F","E","X"};
        rv.setAdapter(new MyAdapter(strs));

        // 设置菜单创建器。
        rv.setSwipeMenuCreator(swipeMenuCreator);
// 设置菜单Item点击监听。
       rv.setSwipeMenuItemClickListener(new OnSwipeMenuItemClickListener() {
           @Override
           public void onItemClick(Closeable closeable, int adapterPosition, int menuPosition, int direction) {
               closeable.smoothCloseMenu();// 关闭被点击的菜单。
               Log.i("gsc","onItemClick"+menuPosition);
           }
       });
//        rv.setLongPressDragEnabled(true);//开启长按拖拽
//        rv.setItemViewSwipeEnabled(true);//开启侧滑删除
//        // 打开第一个Item的左侧菜单。
//       rv.openLeftMenu(0);
//
//// 打开第一个Item的右侧菜单。
//       // rv.openRightMenu(0);
//        //监听拖拽和侧滑删除，更新UI和数据。
//       rv.setOnItemMoveListener(new OnItemMoveListener() {
//           @Override
//           public boolean onItemMove(int fromPosition, int toPosition) {
//               return false;
//           }
//
//           @Override
//           public void onItemDismiss(int position) {
//
//           }
//       });
    }
    /**
     * 菜单创建器。在Item要创建菜单的时候调用。
     */
   private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {

            SwipeMenuItem addItem = new SwipeMenuItem(MainActivity.this).setBackgroundColor(Color.RED)
                    // 点击的背景。
                    .setImage(R.mipmap.ic_launcher) // 图标。
                    .setWidth(60) // 宽度。
                    .setHeight( ViewGroup.LayoutParams.MATCH_PARENT); // 高度。
            swipeLeftMenu.addMenuItem(addItem); // 添加一个按钮到左侧菜单。

                SwipeMenuItem deleteItem = new SwipeMenuItem(MainActivity.this).setBackgroundColor(Color.GREEN)

                        .setImage(R.mipmap.ic_launcher) // 图标。
                        .setText("删除") // 文字。
                        .setTextColor(Color.WHITE) // 文字颜色。
                        .setTextSize(16) // 文字大小。
                        .setWidth(60)
                        .setHeight( ViewGroup.LayoutParams.MATCH_PARENT);
                swipeRightMenu.addMenuItem(deleteItem);// 添加一个按钮到右侧侧菜单。.

            // 上面的菜单哪边不要菜单就不要添加。
        }
    };
}
