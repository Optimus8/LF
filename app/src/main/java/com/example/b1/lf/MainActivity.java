package com.example.b1.lf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLog, btnSig;
    private EditText etEmail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLog = (Button)findViewById(R.id.btnLog);
        btnLog.setOnClickListener(this);
        btnSig = (Button)findViewById(R.id.btnSig);
        btnSig.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btnLog):
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                break;
            case (R.id.btnSig):
                startActivity(new Intent(MainActivity.this, SigninActivity.class));
                break;
        }
    }
}
