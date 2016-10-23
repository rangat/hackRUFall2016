package com.culinera.culinera;

import android.Manifest;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import android.view.View;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.multi.DialogOnAnyDeniedMultiplePermissionsListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dexter.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        CardView vote = (CardView)findViewById(R.id.signedPic_card);
        CardView view = (CardView)findViewById(R.id.viewData_card);
        Intent intent = new Intent(this, VoteActivity.class);
        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Start voting bro", Snackbar.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "View voting data", Snackbar.LENGTH_SHORT).show();
            }
        });



    }



}
