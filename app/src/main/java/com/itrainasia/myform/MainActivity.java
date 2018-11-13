package com.itrainasia.myform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, emailEditText, cellEditText, messageEditText, phoneEditText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.name_editText);
        emailEditText = findViewById(R.id.email_editText);
        cellEditText = findViewById(R.id.cell_editText);
        messageEditText = findViewById(R.id.message_editText);
        phoneEditText = findViewById(R.id.phone_editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String cell = cellEditText.getText().toString();
                String message = messageEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String messageToShow = "Hello "+name + ". EMail is "+email + ". Cell is "+cell+ " . Phone is "+phone+" . Message is "+message;
                Log.d("debug",messageToShow);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("cell",cell);
                intent.putExtra("message",message);
                intent.putExtra("phone",phone);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about_us:
                //Create a new Activity, call it WebActivity
                //Open that Activity
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(intent);
                break;
            case R.id.quit:
                finish();
                break;
            case R.id.check_version:
                //Create a Toast to show
                //You app is on version 1.0
                Toast.makeText(MainActivity.this,"Your app version is 1.0", Toast.LENGTH_LONG).show();
                break;
            case R.id.send_email:
                break;
            case R.id.contact_us:
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                startActivity(phoneIntent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
