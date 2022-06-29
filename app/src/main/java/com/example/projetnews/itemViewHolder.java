package com.example.projetnews;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class itemViewHolder  extends RecyclerView.ViewHolder {
    TextView content;
    TextView title;
    View view;
    itemViewHolder(View itemView){
        super(itemView);
        title=(TextView) itemView.findViewById(R.id.title);
        content= (TextView) itemView.findViewById(R.id.content);
        view= itemView;

    }
}
