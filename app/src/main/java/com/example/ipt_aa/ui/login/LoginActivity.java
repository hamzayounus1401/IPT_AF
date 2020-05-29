package com.example.ipt_aa.ui.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ipt_aa.Model.Student;
import com.example.ipt_aa.NavigationDrawer;
import com.example.ipt_aa.R;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    Button loginButton;
    Context context;
    CardView cardView;
    Animation animation;
    ProgressBar progressBar;
    CoordinatorLayout rootlt;
    EditText usernameEditText;
    EditText passwordEditText;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressbarlogin);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        passwordEditText = findViewById(R.id.password);
        usernameEditText = findViewById(R.id.username);
        loginButton = findViewById(R.id.login);
        rootlt = findViewById(R.id.rootlayoutlogin);
        cardView = findViewById(R.id.cardviewlogin);

        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        loginButton.setOnClickListener(onClickListenerButton);


        loginViewModel.ErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s != null) {
                    Toast.makeText(getApplicationContext(), s.toString(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
        loginViewModel.getLoginResult().observe(this, new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                if (student == null)
                    return;
                else
                    updateUiWithUser(student);
            }
        });


    }

    private void updateUiWithUser(Student user) {
        Toast.makeText(getApplicationContext(), "Welcome: " + user.getFullName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), NavigationDrawer.class);
        startActivity(intent);
        finish();
    }


    public void login(String username, String password) {
        loginViewModel.login(username, password);
    }

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
                loginButton.setEnabled(false);
                loginButton.setBackground(new ColorDrawable(Color.LTGRAY));
            } else if (passwordEditText == null) {
                passwordEditText.setError("Enter password");
                loginButton.setEnabled(false);
                loginButton.setBackground(new ColorDrawable(Color.LTGRAY));
            } else if (passwordEditText.getText().length() <= 4) {
                passwordEditText.setError("Password should be greater than 4");
                loginButton.setBackground(new ColorDrawable(Color.LTGRAY));

                loginButton.setEnabled(false);
            } else {
                loginButton.setBackground(new ColorDrawable(getColor(R.color.dark_slate_blue)));
                loginButton.setEnabled(true);
            }
        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.lefttoright);
        cardView.startAnimation(animation);
    }

    Button.OnClickListener onClickListenerButton =
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getId() == loginButton.getId()) {
                        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                        loginButton.startAnimation(animation);
                        progressBar.setVisibility(View.VISIBLE);
                        login(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                    }
                }
            };
}