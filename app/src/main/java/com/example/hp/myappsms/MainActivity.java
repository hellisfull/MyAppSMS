package com.example.hp.myappsms;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText call,msg;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call=(EditText)findViewById(R.id.ed);
        msg=(EditText)findViewById(R.id.editText);
        bt=(Button)findViewById(R.id.btn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String callid=call.getText().toString();
                String msgid=msg.getText().toString();
                Intent ii=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi=PendingIntent.getActivities(getApplicationContext(),0, new Intent[]{ii},0);
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(callid,null,msgid,pi,null);
                Toast.makeText(getApplicationContext(),"message send",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
