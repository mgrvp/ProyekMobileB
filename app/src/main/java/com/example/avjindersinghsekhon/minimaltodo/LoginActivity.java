package com.example.avjindersinghsekhon.minimaltodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.avjindersinghsekhon.minimaltodo.menu.MainActivitymenu;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText inputUsername, inputpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        inputUsername= (EditText) findViewById(R.id.inputUsername);
        inputpassword= (EditText) findViewById(R.id.inputpassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(inputUsername.getText().toString().equals("")){
                    inputUsername.setError("Username tidak boleh kosong!!!");
                    inputUsername.requestFocus();
                }else if(inputpassword.getText().length() < 5){
                    inputpassword.setError("Password berisi minimal 5 karakter!!!");
                    inputpassword.requestFocus();
                }else{
                    Intent i = new Intent(getApplicationContext(), MainActivitymenu.class);
                    startActivity(i);
                    inputUsername.requestFocus();
                }


            }
        });
    }
}
