package com.example.projetnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.Collections;
import java.util.List;

public class ItemAdapter extends FirebaseRecyclerAdapter<Post,itemViewHolder> {
    List<Post> list = Collections.emptyList();
    Context context;
    ClickListener clickListener;

    public ItemAdapter(@NonNull FirebaseRecyclerOptions<Post> options, ClickListener clickListener) {
       super(options);
       this.clickListener=clickListener;
    }

    @Override
    protected  void onBindViewHolder(@NonNull itemViewHolder holder,
                     int position, @NonNull Post post)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.content.setText(post.getContent());
        final int index = holder.getAdapterPosition();

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.title.setText(post.getTitle());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.click(index,post);
            }
        });


    }

    @NonNull
    @Override
    public itemViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new itemViewHolder(view);
    }

}