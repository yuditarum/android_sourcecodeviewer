package com.yuditarum.urlviewer;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    static TextView myText;

    ConnectivityManager myConnManager;
    NetworkInfo myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView)findViewById(R.id.myResult);

        myConnManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        myInfo = myConnManager.getActiveNetworkInfo();
    }

    public void doSomething(View view) {
        if (myInfo != null && myInfo.isConnected()){
            c1 = new ConnectInternetTask(this);
            c1.execute("http://www.google.com");
        }
        else {
            Toast.makeText(this,"Internet not Connected", Toast.LENGTH_SHORT).show();
        }
    }
}
