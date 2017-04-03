package sdacademy.pl.simpleform;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText enterLogin;
    private EditText enterPassword;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterLogin = (EditText) findViewById(R.id.enterLogin);
        enterPassword = (EditText) findViewById(R.id.enterPassword);
        confirmButton = (Button) findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               verify();
            }
        });
    }

    private void verify(){
        String login = enterLogin.getText().toString();
        String password = enterPassword.getText().toString();
        String confirmation = "Created account: " + login + " "  + password;

        if(login.isEmpty() || password.isEmpty()) {

//            this to kontekst, ktory zawiera wlasciwosci tego Toast
//            klasa Acticity dziedziczy po Context

//            getString odwolanie do zasobu

            Toast.makeText(this, getString(R.string.empty_field), Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, confirmation, Toast.LENGTH_LONG).show();
            enterLogin.setText(" ");
            enterPassword.setText(" ");
        }

    }

}
