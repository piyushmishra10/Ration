package com.fts.ration;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText userName;
    EditText Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        showDialog();
    }

    void showDialog() {
        final Dialog login = new Dialog(MainActivity.this);
        login.requestWindowFeature(Window.FEATURE_NO_TITLE);
        login.setContentView(R.layout.login_dialog);
        login.setCanceledOnTouchOutside(false);

        //  login.setTitle("Login to Pulse 7");
        // Init button of login GUI
        Button btnLogin = (Button) login.findViewById(R.id.btnLogin);
        Button btnCancel = (Button) login.findViewById(R.id.btnCancel);
        final EditText txtUsername = (EditText) login.findViewById(R.id.txtUsername);
        final EditText txtPassword = (EditText) login.findViewById(R.id.txtPassword);

        // Attached listener for login GUI button
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUsername.getText().toString().trim().length() > 0 && txtPassword.getText().toString().trim().length() > 0 && txtUsername.getText().toString().trim().equalsIgnoreCase("admin") && txtPassword.getText().toString().trim().equalsIgnoreCase("admin")) {
                    // Validate Your login credential here than display message
                    Toast.makeText(MainActivity.this,
                            "Login sucessful", Toast.LENGTH_LONG).show();

                    // Redirect to dashboard / home screen.
                    login.dismiss();
                } else if(txtUsername.getText().toString().trim().length() > 0 && txtPassword.getText().toString().trim().length() > 0){
                    Toast.makeText(MainActivity.this,
                            "Please enter Correct Username and Password", Toast.LENGTH_LONG).show();

                }else
                    Toast.makeText(MainActivity.this,
                            "Please enter Username and Password", Toast.LENGTH_LONG).show();
            }
        });
        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                login.dismiss();
            }
        });

        login.show();

        login.getWindow().setLayout(400, 300);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
