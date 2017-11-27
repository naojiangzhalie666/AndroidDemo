package cc.wxf.androiddemo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import cc.wxf.androiddemo.indicator.IndicatorView;

public class MainActivity extends FragmentActivity {

    private IndicatorView indicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIndicator();
    }

    private void initIndicator(){
        indicatorView = (IndicatorView)findViewById(R.id.indicator);
        Resources resources = getResources();
        indicatorView.color(resources.getColor(android.R.color.black),
                resources.getColor(android.R.color.holo_red_light),
                resources.getColor(android.R.color.darker_gray))
                .textSize(sp2px(this, 16))
                .padding(new int[]{dip2px(this, 14), dip2px(this, 14), dip2px(this, 14), dip2px(this, 14)})
                .text(new String[]{"电视剧","电影","综艺","片花","动漫","娱乐","会员1","会员2","会员3","会员4","会员5","会员6"})
                .defaultSelect(0).lineHeight(dip2px(this, 3))
                .listener(new IndicatorView.OnIndicatorChangedListener(){

                    @Override
                    public void onChanged(int position){

                    }
                }).commit();
    }

    public static int dip2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue){
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(spValue * scale + 0.5f);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        indicatorView.release();
    }
}
