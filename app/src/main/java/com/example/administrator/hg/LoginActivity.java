package com.example.administrator.hg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
/**
 * Created by Administrator on 2017/10/16.
 */

public class LoginActivity extends AppCompatActivity {

    private Button dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dl = (Button) findViewById(R.id.dl);
        dl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ZhuyeActivity.class);
                startActivity(intent);
            }
        });
    }

}
