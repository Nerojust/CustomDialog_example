package com.nerojust.customdialog;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailET, passwordET;
    Button clickBtn, loginButton;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    private void initViews() {
        clickBtn = findViewById(R.id.showdialogbutton);
    }

    private void initListeners() {
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialogWithDetails();
            }
        });
    }

    private void createDialogWithDetails() {
        alertDialog = new AlertDialog.Builder(MainActivity.this);
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_login, null);
        emailET = view.findViewById(R.id.etEmail);
        passwordET = view.findViewById(R.id.etPassword);
        loginButton = view.findViewById(R.id.btnLogin);

        alertDialog.setView(view);
        AlertDialog ad = alertDialog.create();
        ad.show();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();
                if (!email.isEmpty()) {
                    if (!password.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Login successful \n ".concat(email.concat(" ") + password), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "password required", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Email required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
