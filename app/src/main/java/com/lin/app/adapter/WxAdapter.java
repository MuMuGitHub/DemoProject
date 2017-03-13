package com.lin.app.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lin.app.R;
import com.lin.app.bean.WxItemModel;
import com.lin.common.baseapp.AppUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import java.util.List;

/**
 * Created by lin on 2017/3/12.
 */

public class WxAdapter extends RecyclerView.Adapter <WxAdapter.WxViewHolder>{

    private List<WxItemModel> models;
    private DisplayImageOptions options;
    public WxAdapter(List<WxItemModel> models) {
        this.models = models;
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) // resource or drawable
                .showImageForEmptyUri(R.mipmap.ic_launcher) // resource or drawable
                .showImageOnFail(R.mipmap.ic_launcher) // resource or drawable
                .resetViewBeforeLoading(false)  // default
                .delayBeforeLoading(1000)
                .cacheInMemory(true) // default
                .cacheOnDisk(true) // default
                .considerExifParams(false) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                .displayer(new SimpleBitmapDisplayer()) // default
                .handler(new Handler()) // default
                .build();
    }

    @Override
    public WxAdapter.WxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        WxViewHolder holder = new WxViewHolder(
                LayoutInflater.from(AppUtils.getInstance().getContext())
                        .inflate(R.layout.item_wxwinnow,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(WxAdapter.WxViewHolder holder, int position) {
        holder.textView.setText(models.get(position).getTitle());
        ImageLoader.getInstance().displayImage(models.get(position).getFirstImg(),holder.imageView, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                Log.e("linwl","onLoadingStarted");

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                Log.e("linwl","onLoadingFailed");

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Log.e("linwl","onLoadingComplete");

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                Log.e("linwl","onLoadingCancelled");

            }
        }, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
                Log.e("linwl", " total   : " + total + "current   : " + current);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models == null ? 0 : models.size();
    }

    class WxViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public WxViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
            imageView = (ImageView)itemView.findViewById(R.id.iv_img);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public void addData(WxItemModel wxItemModel){
        models.add(wxItemModel);
        notifyItemInserted(models.size()-1);
    }

    public void setData(List<WxItemModel> models){
        this.models = models;
        notifyDataSetChanged();

    }
}
