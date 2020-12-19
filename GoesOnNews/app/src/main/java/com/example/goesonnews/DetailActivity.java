package com.example.goesonnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView mTitle = findViewById(R.id.titleNews);
        TextView mPublished = findViewById(R.id.published);
        TextView mKonten = findViewById(R.id.konten);
        TextView mAuthor = findViewById(R.id.author);

        mTitle.setText(getIntent().getStringExtra("Judul"));
        mPublished.setText("Published at : " + getIntent().getStringExtra("Published at"));
        mKonten.setText("\n" + getIntent().getStringExtra("Content"));
        mAuthor.setText("Author : " + getIntent().getStringExtra("Author"));

    }
}