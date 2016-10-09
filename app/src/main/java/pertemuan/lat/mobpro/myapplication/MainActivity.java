package pertemuan.lat.mobpro.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login, register;
    EditText username, passw;
    Intent serviceIntent;

    SessionManager sessionman;

    String getUser,getPass, getEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.btnLogin);
        register = (Button) findViewById(R.id.btnRegister);
        username = (EditText) findViewById(R.id.editUserName);
        passw = (EditText) findViewById(R.id.editPassword);

        sessionman = new SessionManager(getApplicationContext());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });


//        final String usern = username.getText().toString();
//        final String pass = passw.getText().toString();

        getUser = sessionman.getUserDetails().get(sessionman.MyUsername);
        getEmail = sessionman.getUserDetails().get(sessionman.MyEmail);
        getPass = sessionman.getUserDetails().get(sessionman.MyPassword);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((username.getText().toString().equals("aldy")) && (passw.getText().toString().equals("1234"))) {
//                    sessionman.setLogStatus(true);
                    // Staring MainActivity
                    startActivity(new Intent(MainActivity.this, MainAppsActivity.class));
                }
//              else {
//                    Toast.makeText(getApplicationContext(), "Login salah", Toast.LENGTH_SHORT);
//                }
            }
        });
    }


}
