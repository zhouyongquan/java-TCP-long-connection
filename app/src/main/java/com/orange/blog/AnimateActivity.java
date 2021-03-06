package com.orange.blog;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.orange.blog.Adapter.AllFeatureAdapter;
import com.orange.blog.Adapter.DividerItemDecoration;

import butterknife.BindView;

/**
 * Created by orange on 16/5/27.
 */
public class AnimateActivity extends BaseActivity {
    @BindView(R.id.lv_all_feature)
    RecyclerView lv_all_feature;

    AllFeatureAdapter allFeatureAdapter;
    String[] allFeatureName;
    @Override
    int initContentView() {
        return R.layout.all_feature_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        allFeatureName =new String[]{"属性动画位之移颜色变化","笑脸动画","viewPager引导&&Indicator动画","闪动效果"};
        allFeatureAdapter=new AllFeatureAdapter(this, allFeatureName);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        lv_all_feature.setLayoutManager(layoutManager);
        lv_all_feature.setItemAnimator(new DefaultItemAnimator());
        lv_all_feature.addItemDecoration(new DividerItemDecoration(Color.parseColor("#000000"),2));
        lv_all_feature.setAdapter(allFeatureAdapter);
        initListener();
    }

    private void initListener(){
        allFeatureAdapter.setOnItemtClickListener(new AllFeatureAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(AnimateActivity.this, ValueAnimatorActivityTranslate.class);
                        break;
                    case 1:
                        intent = new Intent(AnimateActivity.this, SmileActivity.class);
                        break;
                    case 2:
                        intent = new Intent(AnimateActivity.this, FeatureGuidActivity.class);
                        break;
                    case 3:
                        intent = new Intent(AnimateActivity.this, ShimmerActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}
