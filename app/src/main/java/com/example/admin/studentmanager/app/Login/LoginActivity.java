package com.example.admin.studentmanager.app.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.app.GettingStartedActivity;
import com.example.admin.studentmanager.model.DummyType;
import com.example.admin.studentmanager.model.Group;

import java.util.HashMap;
import java.util.Random;

import static com.example.admin.studentmanager.manager.GroupManager.sGroups;

/**
 * Created by admin on 24.06.2017.
 */

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();;
    public static HashMap<String, String> sLogins = new HashMap<>();
    private LinearLayout mLinearLayout;
    private TextView tvLogin;
    private Button btnLogin;
    private Button btnReg;
    private EditText edtLogin;
    private EditText edtPassword;

    static {
        sLogins.put("admin", "admin");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnReg = (Button) findViewById(R.id.btnReg);
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAutorized(edtLogin.getText().toString(), edtPassword.getText().toString())) {
                    Intent intent = new Intent(LoginActivity.this, GettingStartedActivity.class);
                    intent.putExtra("login", edtLogin.getText().toString());
                    startActivity(intent);
                }
                else {
                Toast.makeText(LoginActivity.this, "Wrong login or password", Toast.LENGTH_LONG).show();
            }
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (data == null) return;
        String name = data.getStringExtra("login");
        edtLogin.setText(name);
    }

    private void initGroups() {
        Random random = new Random();
        int [] images =DummyType.getImages();
        for (int i = 0; i< DummyType.GROUPNAMES.length; i++) {
            Group group = new Group(("Группа " + DummyType.GROUPNAMES[i]), images[i]);
            sGroups.put((long) i,group);
        }
    }


    private boolean isAutorized(String login, String password) {
        return ((login != null) && (password != null) &&
                (sLogins.containsKey(login) && sLogins.get(login).equals(password)));
    }
}
