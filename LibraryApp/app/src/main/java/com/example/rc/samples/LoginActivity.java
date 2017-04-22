package com.example.rc.samples;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.mail_editText)
    protected EditText mail_editText;

    @BindView(R.id.password_editText)
    protected EditText password_editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.next_button)
    public void submitForm() {

//        3 parametry: wejsciowy, w trakcie - z tego raczej nie korzystamy, wyjsciowy

        new AsyncTask<LoginModel, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(LoginModel... loginModels) {

//                logika wysylajaca posta na serwer - do osobnej klasy, bo bedzie reuzywana w rejestracji

                return UserServiceSingleton.getInstance().login(loginModels[0]);
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {

            }
        }.execute(new LoginModel(mail_editText.getText().toString(), password_editText.getText().toString()));
    }
}
