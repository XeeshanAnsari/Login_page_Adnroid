package com.example.xesshan.login_page;

import android.content.Intent;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button login_btn;
    private static TextView Attempts;
    int attempt_counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButtonn();
    }
    public void LoginButtonn(){
        username = (EditText)findViewById(R.id.editText_username);
        password = (EditText)findViewById(R.id.editText_password);
        Attempts = (TextView)findViewById(R.id.textView);
        login_btn = (Button)findViewById(R.id.button);
        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("Xeeshan") && password.getText().toString().equals("Shani")){
                            Toast.makeText(MainActivity.this,"Username and password is correct",Toast.LENGTH_LONG).show();
                            Intent intent= new Intent("com.example.xesshan.login_page.Welcome");
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this,"Username and password is not correct",Toast.LENGTH_LONG).show();
                            attempt_counter --;
                            Attempts.setText(Integer.toString(attempt_counter));
                            if(attempt_counter==0){
                                login_btn.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }
}
