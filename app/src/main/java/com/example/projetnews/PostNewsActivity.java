package com.example.projetnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class PostNewsActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Post post;
    private EditText contentEdt, titleEdt;
    private Button sendData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Get the instance of the firebase database
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference();
        DatabaseReference newFirebaseDatabase = databaseReference.push();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_news);
        titleEdt = findViewById(R.id.editTextTitle);
        contentEdt = findViewById(R.id.editContent);

        sendData=findViewById(R.id.button);

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title= titleEdt.getText().toString();
                String content=contentEdt.getText().toString();
                if(TextUtils.isEmpty(title) && TextUtils.isEmpty(content)){
                    Toast.makeText(PostNewsActivity.this, "Add data", Toast.LENGTH_SHORT).show();
                }else{

                    newFirebaseDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            post = new Post();
                            // inside the method of on Data change we are setting
                            // our object class to our database reference.
                            // data base reference will sends data to firebase.
                            post.setContent(content);
                            post.setTitle(title);
                            newFirebaseDatabase.setValue(post);

                            // after adding this data we are showing toast message.
                            Toast.makeText(PostNewsActivity.this, "data added", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            // if the data is not added or it is cancelled then
                            // we are displaying a failure toast message.
                            Toast.makeText(PostNewsActivity.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });




    }
}