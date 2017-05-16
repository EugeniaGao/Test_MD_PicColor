package com.jing.www.recyclerviewrefresh;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

/*public int [] pic= new int[]{R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p9,
        R.drawable.p10,R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,
        R.drawable.p20,R.drawable.p21,R.drawable.p22,R.drawable.p23,R.drawable.p24,R.drawable.p25,R.drawable.p26,R.drawable.p27,R.drawable.p28,R.drawable.p29,
        R.drawable.p30,R.drawable.p31,R.drawable.p32,R.drawable.p33,R.drawable.p34,R.drawable.p35,R.drawable.p36,R.drawable.p37,R.drawable.p38,R.drawable.p39,
        R.drawable.p40,R.drawable.p41,R.drawable.p42,R.drawable.p43,R.drawable.p44};*/
public int [] pic= new int[]{R.drawable.m8,R.drawable.m7,R.drawable.m6,R.drawable.m5,R.drawable.m4,R.drawable.m3,R.drawable.m2};
   private Handler mHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //0.找到Rv控件
       RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
       final SwipeRefreshLayout swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.re_grid);
        swipeRefreshLayout.setBackgroundColor(Color.BLUE);
        swipeRefreshLayout.setColorSchemeColors(Color.GREEN,Color.RED,Color.YELLOW);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(MainActivity.this,"正在加载网络数据",Toast.LENGTH_SHORT).show();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },300);
            }
        });
        //1.创建布局管理器
        /*参数:上下文,列数*/
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);
       rv.setAdapter(new MyRecyclerAdapter());
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter {
        @Override  //创建适配器,先渲染子布局,传给viewholder
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item,null);
            return new MyRecyclerViewHolder(view);
        }

        @Override //设置ViewHoler,给viewHolder绑定数据
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyRecyclerViewHolder viewHolder= (MyRecyclerViewHolder) holder;
            viewHolder.setDatas(position);
        }



        @Override
        public int getItemCount() {
            return pic==null?0:pic.length-1;
        }
    }

    private class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

         ImageView imagView;
        TextView textView;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            imagView = (ImageView) itemView.findViewById(R.id.iv_grid);
            textView = (TextView) itemView.findViewById(R.id.tv_grid);
        }

        public void setDatas(int position) {
           textView.setText("这是第"+position+"个条目");
            imagView.setBackgroundResource(pic[position]);
            }
        }
    }

