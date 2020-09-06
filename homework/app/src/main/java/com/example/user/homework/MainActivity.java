package com.example.user.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    void calculation(View view){
        EditText n1text = findViewById(R.id.editText);
        String n1Str = n1text.getText().toString();
        int n1 = Integer.parseInt(n1Str);

        EditText n2text = findViewById(R.id.editText2);
        String n2Str  = n2text.getText().toString();
        int n2 = Integer.parseInt(n2Str);
    switch (view.getId()){

    }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
