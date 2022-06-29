package com.example.projetnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button createPost;
    Button readPosts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        createPost = (Button) findViewById(R.id.post_news);
        readPosts= (Button) findViewById(R.id.read_news);

        createPost.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PostNewsActivity.class);
                view.getContext().startActivity(intent);}
        });
        readPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), ShowPostsActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        super.onCreate(savedInstanceState);

    }



}