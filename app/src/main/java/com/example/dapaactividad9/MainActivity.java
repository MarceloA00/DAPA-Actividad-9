package com.example.dapaactividad9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBrodcastSenderBtnClick(View v) {

        String number= "8180856100";
        String msg= "Test Message";
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number,null,msg,null,null);
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),String.valueOf(e),Toast.LENGTH_LONG).show();
        }

    }
}