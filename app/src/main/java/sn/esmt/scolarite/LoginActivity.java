package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailText;
    private EditText password;
    private EditText validerbt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText emailText = (EditText) findViewById(R.id.emailText);
        EditText password= (EditText) findViewById((R.id.password)) ;
        Button validerbt= (Button) findViewById(R.id.Validerbt);



        validerbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailText.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty() || pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Veuiller renseigner les champs",Toast.LENGTH_LONG).show();
                }
                else
                    if (email.equals("esmt@esmt.sn") && pwd.equals("123")){
                        Intent i= new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Email ou mot de passe incorrect",Toast.LENGTH_LONG).show();


                    }


            }
        });
    }
}