package com.example.projetnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowPostsActivity extends AppCompatActivity {
    //Create an object of the adpater class
    ItemAdapter adapter;
    RecyclerView recyclerView;
    ClickListener listener;

    DatabaseReference postsReference;
    //Create an object of firebase database
    DatabaseReference firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        //postsReference = firebaseDatabase.child("Posts");



        setContentView(R.layout.activity_show_posts);
        List<Post> posts = new ArrayList<Post>();
        //posts = getData();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        listener = new ClickListener() {
            @Override
            public void click(int index,Post post) {
                //Pass post data to PostActivity in extra
                Intent intent=new Intent(ShowPostsActivity.this,PostActivity.class);
                intent.putExtra("title",post.getTitle());
                intent.putExtra("content",post.getContent());
                startActivity(intent);
                finish();
            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(ShowPostsActivity.this));
        FirebaseRecyclerOptions<Post> options= new FirebaseRecyclerOptions.Builder<Post>().setQuery(firebaseDatabase,Post.class).build();
        adapter = new ItemAdapter(options,listener);
        recyclerView.setAdapter(adapter);
    }
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stopping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }

    private List<Post> getData() {


        ArrayList<Post> list = new ArrayList<>();
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Post post = ds.getValue(Post.class);
                    list.add(post);
                    Log.d("TAG", post.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        };
        postsReference.addListenerForSingleValueEvent(valueEventListener);
        return list;
    }
}

