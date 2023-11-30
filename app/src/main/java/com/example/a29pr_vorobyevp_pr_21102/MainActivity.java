package com.example.a29pr_vorobyevp_pr_21102;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton cameraButton;
    private ImageButton mapsButton;
    private ImageButton googleButton;
    private ImageButton contactsButton;
    private ImageButton otherAppButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraButton = findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(this);

        mapsButton = findViewById(R.id.mapsButton);
        mapsButton.setOnClickListener(this);

        googleButton = findViewById(R.id.googleButton);
        googleButton.setOnClickListener(this);

        contactsButton = findViewById(R.id.contactsButton);
        contactsButton.setOnClickListener(this);

        otherAppButton = findViewById(R.id.otherAppButton);
        otherAppButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cameraButton) {
            openCamera();
        } else if (v.getId() == R.id.mapsButton) {
            openMaps();
        } else if (v.getId() == R.id.googleButton) {
            openGoogle();
        } else if (v.getId() == R.id.contactsButton) {
            openContacts();
        } else if (v.getId() == R.id.otherAppButton) {
            openOtherApp();
        }
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    private void openMaps() {
        Uri locationUri = Uri.parse("geo:0,0?q=Google+Maps");
        Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);
        startActivity(intent);
    }

    private void openGoogle() {
        Uri googleUri = Uri.parse("http://www.google.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, googleUri);
        startActivity(intent);
    }

    private void openContacts() {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivity(intent);
    }

    private void openOtherApp() {
        String url = "https://natk.ru/stud-grad/schedule/187?group=%D0%9F%D0%A0-21.102";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
