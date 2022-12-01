package com.example.nepali_english.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nepali_english.mynotes.dboperations.MyNotesDatabaseHelper;

public class MainHomeActivity extends AppCompatActivity {
    private CardView li_todo,li_catatan,li_wish;
    private ImageView home;
    MyNotesDatabaseHelper myNotesDatabaseHelper;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        li_todo = findViewById(R.id.todo);
        li_catatan = findViewById(R.id.catatan);
        li_wish = findViewById(R.id.wish);
        home = findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainHomeActivity.this,MainHomeActivity.class);
                startActivity(home);
            }
        });
        li_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent li_todo = new Intent(MainHomeActivity.this,MainTodoActivity.class);
                startActivity(li_todo);
            }
        });
        myNotesDatabaseHelper = new MyNotesDatabaseHelper(this);
        li_catatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status =Integer.parseInt( myNotesDatabaseHelper.getLoginData(email, password));
                if (status>0) {
                    Intent li_catatan = new Intent(getApplicationContext(), AllNotesScreenActivity.class);
                    li_catatan.putExtra("username", email);
                    startActivity(li_catatan);
                }
                else {

                    return;
                }
            }
        });
        li_wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent li_wish = new Intent(MainHomeActivity.this,MainWishActivity.class);
                startActivity(li_wish);
            }
        });
    }
}