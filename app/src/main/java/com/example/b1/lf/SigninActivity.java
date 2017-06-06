package com.example.b1.lf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSig;
    private TextView tvLogin;
    private EditText etEmail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        tvLogin = (TextView)findViewById(R.id.tvLogin);
        btnSig = (Button)findViewById(R.id.btnSig);
        btnSig.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSig:
                registr();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(SigninActivity.this, MainActivity.class));
                break;
            default:
        }
    }
    private void registr(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if (email.isEmpty() && pass.isEmpty()) {
            displayToast("Введите Логин/Пароль!");

        }else {
            displayToast("Пользователь зарегестрирован!");
            finish();
        }
    }
    private void displayToast(String massage){
        Toast.makeText(getApplicationContext(), massage, Toast.LENGTH_SHORT).show();
    }
}
