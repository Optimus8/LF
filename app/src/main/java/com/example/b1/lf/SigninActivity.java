package com.example.b1.lf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import io.realm.Realm;

import static com.example.b1.lf.R.id.etEmail;
import static com.example.b1.lf.R.id.etPass;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSig;
    private TextView tvLogin;
    private EditText _etEmail, _etPass;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        _etEmail = (EditText) findViewById(etEmail);
        _etPass = (EditText) findViewById(etPass);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        btnSig = (Button) findViewById(R.id.btnSig);
        btnSig.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSig:
                realm.beginTransaction();

                PersonObject personObject = realm.createObject(PersonObject.class);
                personObject.setId(new Date().toString());
                personObject.setMail(_etEmail.getText().toString());
                personObject.setPass(_etPass.getText().toString());

                realm.commitTransaction();

                Toast.makeText(this, "Пользователь зарегестрирован!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SigninActivity.this, MainActivity.class));
                break;

            case R.id.tvLogin:
                startActivity(new Intent(SigninActivity.this, MainActivity.class));
                break;
            default:
        }
    }
}

