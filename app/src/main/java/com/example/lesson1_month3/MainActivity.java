package com.example.lesson1_month3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSend = findViewById(R.id.btn_send);
        EditText txtTo = findViewById(R.id.edt_txt);
        EditText txtSubject = findViewById(R.id.edt_txt2);
        EditText txtMessage = findViewById(R.id.edt_txt3);

        
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String to = txtTo.getText().toString();
                String theme = txtSubject.getText().toString();
                String message = txtMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, theme);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Выберите email клиент :"));
                

            }
        });
    }
}