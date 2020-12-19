package com.example.goesonnews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.goesonnews.DetailActivity;
import com.example.goesonnews.Model.ArticlesItem;
import com.example.goesonnews.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ArrayList<ArticlesItem> mNewsData;
    private Context mContext;

    public NewsAdapter(ArrayList<ArticlesItem> mNewsData, Context mContext) {
        this.mNewsData = mNewsData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mTitle.setText(mNewsData.get(position).getTitle());
        holder.mDescription.setText(mNewsData.get(position).getDescription());
        Glide.with(mContext).load(mNewsData.get(position).getUrlToImage()).error(R.mipmap.ic_launcher).override(512, 512).into(holder.mNewsImage);
        holder.cardClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("Judul", mNewsData.get(position).getTitle());
                intent.putExtra("Published at", mNewsData.get(position).getPublishedAt());
                intent.putExtra("Content", mNewsData.get(position).getContent());
                intent.putExtra("Author", mNewsData.get(position).getAuthor());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private TextView mDescription;
        private ImageView mNewsImage;
        private CardView cardClick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.titleNews);
            mDescription = itemView.findViewById(R.id.descriptionNews);
            mNewsImage = itemView.findViewById(R.id.newsImage);
            cardClick = itemView.findViewById(R.id.card_view);
        }
    }
}
