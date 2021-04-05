package com.example.layouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class send_msg_2_activity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg_2_activity);

        Button sendButton = findViewById(R.id.sendBtn);

        sendButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), receive_msg_3_activ.class);
                EditText editText =  findViewById(R.id.sendMsgId_2);
                String message = editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                view.getContext().startActivity(intent);
            }
        });
    }
}