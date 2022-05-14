package com.example.yoga;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapterClass extends RecyclerView.Adapter<ListAdapterClass.ListViewHolder>{
    Context context;
    List<ModelClass> mData;
    private ListViewHolder.RecycleViewClickListener clickListener;


    public ListAdapterClass(Context context, List<ModelClass> mData, ListAdapterClass.ListViewHolder.RecycleViewClickListener clickListener) {
        this.context = context;
        this.mData = mData;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.list_layout,parent,false);
        return new ListViewHolder(layout,context,mData,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterClass.ListViewHolder holder, int position) {
        String topic = mData.get(position).getTopic().toString();
        String btn = mData.get(position).getBtn().toString();
        int photo = mData.get(position).getPhoto();


        holder.tv_topic.setText(topic);
        holder.tv_btn.setText(btn);
        holder.img_photo.setImageResource(photo);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_topic, tv_btn;
        ImageView img_photo;
        ListAdapterClass.ListViewHolder.RecycleViewClickListener mListener;

        public ListViewHolder(@NonNull View itemView,Context context,List<ModelClass> mData,RecycleViewClickListener clickListener) {
            super(itemView);
            tv_topic = itemView.findViewById(R.id.textView7);
            tv_btn   = itemView.findViewById(R.id.button4);
            img_photo = itemView.findViewById(R.id.imageView4);
            this.mListener = clickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mListener.onClickListener(getAdapterPosition());

        }
        public interface RecycleViewClickListener{
            void onClickListener(int position);

        }
    }
}
