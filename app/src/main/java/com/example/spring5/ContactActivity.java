package com.example.spring5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.spring5.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {
    private ActivityContactBinding contactBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contactBinding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(contactBinding.getRoot());

        contactBinding.sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        contactBinding.wsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp();
            }
        });

        contactBinding.linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkedinUrl();
            }
        });

    }

    private void sendEmail() {
        String input = String.valueOf(contactBinding.inputEmail.getText());

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"j.perezurrutia@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contact");
        intent.putExtra(Intent.EXTRA_TEXT, input);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void openWhatsApp() {
        String phoneNumber = "+491789628516";
        Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }


    private void openLinkedinUrl() {
        String url = "https://www.linkedin.com/in/javier-perez-u/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}