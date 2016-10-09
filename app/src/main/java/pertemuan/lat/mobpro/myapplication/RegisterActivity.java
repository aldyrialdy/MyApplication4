package pertemuan.lat.mobpro.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username,passwd,email,phone;
    Button saveReg;
    String u,p,e,ph;
    boolean stat;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    public static final String MyPref = "MyPrefs" ;
    public static final String MyUsername = "MyUsername";
    public static final String MyPassword = "MyPassword";
    public static final String MyEmail = "MyEmail";
    public static final String MyPhone = "MyPhone";
    public static final String MyStat = "MyStatus";


//    SessionManager sessionman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText)findViewById(R.id.editUserNameReg);
        passwd = (EditText)findViewById(R.id.editPasswordReg);
        email = (EditText)findViewById(R.id.editEmailReg);
        phone = (EditText)findViewById(R.id.editTelpReg);
        saveReg = (Button)findViewById(R.id.btnSave);

        sharedpreferences = getSharedPreferences(MyPref, Context.MODE_PRIVATE);
        stat = false;

        saveReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u = username.getText().toString();
                p = passwd.getText().toString();
                e = email.getText().toString();
                ph = phone.getText().toString();

                editor = sharedpreferences.edit();

                editor.putString(MyUsername,u);
                editor.putString(MyPassword,p);
                editor.putString(MyEmail,e);
                editor.putString(MyPhone,ph);
                editor.putString(MyStat, String.valueOf(stat));
                editor.commit();

//                sessionman = new SessionManager(getApplicationContext());
//                sessionman.createLoginSession(u, p, e, ph, false);


//                sharedpreferences.getString("MyUsername","-");
//                sharedpreferences.getBoolean("MyStatus","-");
                Toast.makeText(getApplicationContext(),"Thanks for registering your account", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),sharedpreferences.getString(MyUsername,"-").toString()+" "
                        +sharedpreferences.getString(MyPassword,"-").toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
