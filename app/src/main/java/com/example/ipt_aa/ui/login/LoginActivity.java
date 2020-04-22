package com.example.ipt_aa.ui.login;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ipt_aa.R;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    Button loginButton;
    Context context;
    Boolean login = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        context = getApplicationContext();
        final TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (usernameEditText == null || !(Pattern.matches("\\D\\d{6}", usernameEditText.getText()))) {
                    usernameEditText.setError("Enter Valid Email Address");
                } else if (passwordEditText == null)
                    passwordEditText.setError("Enter password");

                else if (passwordEditText.getText().length() <= 4)
                    passwordEditText.setError("Password should be greater than 4");

                else {
                    loginButton.setBackground(new ColorDrawable(getColor(R.color.dark_slate_blue)));
                    loginButton.setEnabled(true);
                }
            }
        };


        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());


            }
        });


    }


    private void updateUiWithUser(String user) {
        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(getApplicationContext(), NavigationDrawer.class);
        //      startActivity(intent);
        // TODO : initiate successful logged in experience
        //     Toast.makeText(getApplicationContext(), "hELLOI", Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    public void login(String username, String password) {
        loginViewModel.login(username, password, getApplicationContext()).observe((this), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
        });
    }

}
