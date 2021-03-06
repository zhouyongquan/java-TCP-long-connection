package com.orange.blog.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orange.blog.R;

/**
 * Created by orange on 16/5/10.
 */
public class AllFeatureAdapter extends RecyclerView.Adapter<AllFeatureAdapter.AllFeatureViewHolder> {

    private Context context;
    private String[] features;
    private onItemClickListener onItemClickListener;
    public AllFeatureAdapter(Context context,String[] features){
        this.features=features;
        this.context=context;
    }
    @Override
    public AllFeatureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewRoot=LayoutInflater.from(context).inflate(R.layout.item_text,null);
        return new AllFeatureViewHolder(viewRoot);
    }

    @Override
    public void onBindViewHolder(AllFeatureViewHolder holder, final int position) {
        holder.featureName.setText(features[position]);
        holder.ll_item_containerl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return features.length;
    }

    public class AllFeatureViewHolder extends RecyclerView.ViewHolder{
        private TextView featureName;
        private LinearLayout ll_item_containerl;
        public AllFeatureViewHolder(View itemView) {
            super(itemView);
            featureName= (TextView) itemView.findViewById(R.id.tv_featureName);
            ll_item_containerl= (LinearLayout) itemView.findViewById(R.id.ll_item_container);
        }
    }
    public void setOnItemtClickListener(onItemClickListener itemtClickListener){
        this.onItemClickListener=itemtClickListener;
    }
    public interface onItemClickListener{
        void onItemClick(int position);
    }

}
