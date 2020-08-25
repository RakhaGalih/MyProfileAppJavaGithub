package com.example.myprofileappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MyProfileActivity extends AppCompatActivity {
    public static final String namae = "nama";
    public static final String emaile = "email";
    public static final String telpe = "telp";
    public static final String alamate = "alamat";
    public static final String gendere = "gender";
    TextView txtName, txtEmail, txtTelp, txtAddress, txtGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelp = findViewById(R.id.txtTelp);
        txtAddress = findViewById(R.id.txtAddress);
        txtGender = findViewById(R.id.txtGender);
        ambilData();
    }

    private void ambilData() {
        String nama = getIntent().getStringExtra(namae);
        String email = getIntent().getStringExtra(emaile);
        String telp = getIntent().getStringExtra(telpe);
        String alamat = getIntent().getStringExtra(alamate);
        String gender = getIntent().getStringExtra(gendere);
        txtName.setText(nama);
        txtEmail.setText(email);
        txtTelp.setText(telp);
        txtAddress.setText(alamat);
        txtGender.setText(gender);
    }
}