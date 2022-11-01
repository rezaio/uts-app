package com.reza.daftarbuku;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TampilBuku extends AppCompatActivity {

    TextView tvName, tvDescription;
    ImageView imgPhoto;
    Buku bukuModel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_buku);

        tvName = findViewById(R.id.tv_name_detail);
        tvDescription = findViewById(R.id.tv_description_detail);
        imgPhoto = findViewById(R.id.iv_photo);
        intent = getIntent();

        if(intent != null) {
            bukuModel = (Buku) intent.getParcelableExtra("data");
            String name = bukuModel.getName();
            String description = bukuModel.getDescription();

            tvName.setText(name);
            tvDescription.setText(description);
            imgPhoto.setImageResource(bukuModel.getPhoto());
        }
    }
}