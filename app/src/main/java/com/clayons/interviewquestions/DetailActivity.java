package com.clayons.interviewquestions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity {

    String mData[];
    boolean isClicked = false;

    @Override
    public void onBackPressed() {
        Intent mIntent = new Intent(DetailActivity.this, MainActivity.class);
        mIntent.putExtra("ispressed", isClicked);
        setResult(1, mIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = getIntent().getStringExtra("data").split(",");
        setContentView(R.layout.detail_activity);

        ((TextView) findViewById(R.id.tvFristName)).setText(mData[0]);
        ((TextView) findViewById(R.id.tvLastName)).setText(mData[1]);
        ((TextView) findViewById(R.id.tvAge)).setText(mData[2]);
        ((TextView) findViewById(R.id.tvPhoneNum)).setText(mData[3]);
        // Picasso IMage view

        ((Button) findViewById(R.id.btnLike)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClicked = true;
            }
        });

        Picasso.with(this)
                .load(mData[4])
                .error(R.mipmap.ic_launcher)
                .into(((ImageView) findViewById(R.id.ivAvatar)));


    }
}
