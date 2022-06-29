package com.example.projetnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PostActivity extends AppCompatActivity {
    String title;
    String content;
    TextView titleView;
    TextView contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        titleView=(TextView) findViewById(R.id.title);
        contentView=(TextView)findViewById(R.id.content);

        title= intent.getStringExtra("title");
        content= intent.getStringExtra("content");
        titleView.setText(title);
        contentView.setText(content);
    }
}