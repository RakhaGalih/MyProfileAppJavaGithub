package com.example.myprofileappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName, edtEmail, edtTelp, edtAlamat;
    Spinner spinnerGender = null;
    Button btnSave;
    String namaInput;
    String emailInput;
    String telpInput;
    String alamatInput;
    String genderInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        spinnerGender = findViewById(R.id.spinnerGender);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelp = findViewById(R.id.edtTelp);
        edtAlamat = findViewById(R.id.edtAddress);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        setDataSpinnerGender();
    }

    @Override
    public void onClick(View v) {
        validasiinput();
    }

    private void validasiinput() {
        namaInput = edtName.getText().toString();
        emailInput = edtEmail.getText().toString();
        telpInput = edtTelp.getText().toString();
        alamatInput = edtAlamat.getText().toString();
        genderInput = spinnerGender.getSelectedItem().toString();

        if (TextUtils.isEmpty(namaInput)) {
            edtName.setError("Nama tidak boleh kosong");
        }
        if (TextUtils.isEmpty(emailInput)) {
            edtEmail.setError("Email tidak boleh kosong");
        }
        if (genderInput.equals("Pilih kelamin")){
            Toast.makeText(this, "Kelamin harus dipilih", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(telpInput)) {
            edtTelp.setError("Telepon tidak boleh kosong");
        }
        if (TextUtils.isEmpty(alamatInput)) {
            edtAlamat.setError("Alamat tidak boleh kosong");
        } else {
            Toast.makeText(this, "Navigasi ke halaman profil diri", Toast.LENGTH_SHORT).show();
            navigasiKeProfilDiri();
        }
    }

    private void navigasiKeProfilDiri() {
        Intent intent = new Intent(MainActivity.this, MyProfileActivity.class);
        intent.putExtra(MyProfileActivity.namae, namaInput);
        intent.putExtra(MyProfileActivity.emaile, emailInput);
        intent.putExtra(MyProfileActivity.telpe, telpInput);
        intent.putExtra(MyProfileActivity.alamate, alamatInput);
        intent.putExtra(MyProfileActivity.gendere, genderInput);

        startActivity(intent);
    }

    private void setDataSpinnerGender() {
        Adapter adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_list, android.R.layout.simple_spinner_item);
    }
}