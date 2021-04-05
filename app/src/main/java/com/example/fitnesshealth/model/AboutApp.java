package com.example.fitnesshealth.model;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;


import com.example.fitnesshealth.R;


public class AboutApp extends AppCompatActivity {
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        intent = new Intent(Intent.ACTION_VIEW);

    }

    public void openActivity(View view) {
        intent.setClass(AboutApp.this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.one) {
            intent.setData(Uri.parse("https://www.youtube.com/watch?v=p9Dw-4ycMQQ"));
            startActivity(intent);
        }

        if (id == R.id.two) {
            intent.setData(Uri.parse("https://www.youtube.com/watch?v=5lZE5oY9VFk"));
            startActivity(intent);
        }

        if (id == R.id.two) {
            intent.setData(Uri.parse("https://www.youtube.com/watch?v=TPpoJGYlW54"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }

    public void info1(View view) {
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=p9Dw-4ycMQQ"));
        startActivity(intent);
    }

    public void info2(View view) {
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=5lZE5oY9VFk"));
        startActivity(intent);
    }

    public void info3(View view) {
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=TPpoJGYlW54"));
        startActivity(intent);
    }

    public void twitter(View view) {
        intent.setData(Uri.parse("https://twitter.com/@nickythaii"));
        startActivity(intent);
    }

    public void mail(View view) {
        intent.setData(Uri.parse("https://bit.ly/2UHhaFC"));
        startActivity(intent);
    }

    public void ig(View view) {
        intent.setData(Uri.parse("https://instagram.com/ncckky/"));
        startActivity(intent);
    }
}
