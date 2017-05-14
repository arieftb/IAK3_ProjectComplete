package com.arieftb.percobaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("")  ||
                        etPassword.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(),"Belum Lengkap",
                            Toast.LENGTH_SHORT).show();
                }
                else if (etUsername.getText().toString().equals("admin")
                        && etPassword.getText().toString().equals("admin")){

                    Toast.makeText(LoginActivity.this,"Login Berhasil",
                            Toast.LENGTH_SHORT).show();


                    Bundle mBundle = new Bundle();
                    mBundle.putString("Uname",etUsername.getText().toString());
                    mBundle.putString("Pword", etPassword.getText().toString());
                    Intent mIntent = new Intent(getApplicationContext(),MenuActivity.class);
                    mIntent.putExtras(mBundle);
                    startActivity(mIntent);
                }
                else {

                    Toast.makeText(getApplicationContext(),"Login Gagal",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUsername.setText("");
                etPassword.setText("");
            }
        });
//
//        btnReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                etUsername.setText("");
//                etPassword.setText("");
//            }
//        });
    }
}
