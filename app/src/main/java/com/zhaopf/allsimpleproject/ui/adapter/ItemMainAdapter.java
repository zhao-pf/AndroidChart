package com.zhaopf.allsimpleproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhaopf.allsimpleproject.R;
import com.zhaopf.allsimpleproject.bean.ImageBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemMainAdapter extends RecyclerView.Adapter<ItemMainAdapter.ViewHolder> {

    private List<ImageBean> items = new ArrayList();

    private Context context;
    private LayoutInflater layoutInflater;
    private OnClickChangeFragmentListener listener = null;

    public ItemMainAdapter(Context context, List<ImageBean> items) {
        this.items = items;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void addFragment(ImageBean imageBean) {
        items.add(imageBean);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = layoutInflater.inflate(R.layout.item_main, null);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(items.get(position).getName());
//        BaseFragment fragment = items.get(position).getFragment();
//        holder.iv_ll.addView(fragment.createView());
        listener.onChangeFragment(items.get(position), holder.ivImg,holder.clMain);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setListener(OnClickChangeFragmentListener listener) {
        this.listener = listener;
    }

    public interface OnClickChangeFragmentListener {
        void onChangeFragment(ImageBean bean, ImageView imageView, RelativeLayout clMain);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.cl_main)
        RelativeLayout clMain;
        @BindView(R.id.iv_ll)
        LinearLayout iv_ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
