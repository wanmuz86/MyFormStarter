package com.itrainasia.myform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView nameTextView, emailTextView, cellTextView, phoneTextView, messageTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        cellTextView = findViewById(R.id.cellTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        messageTextView = findViewById(R.id.messageTextView);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String cell = intent.getStringExtra("cell");
        String phone = intent.getStringExtra("phone");
        String message = intent.getStringExtra("message");
        nameTextView.setText(name);
        emailTextView.setText(email);
        cellTextView.setText(cell);
        phoneTextView.setText(phone);
        messageTextView.setText(message);
    }
}
