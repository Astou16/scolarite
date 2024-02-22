package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.scolarite.http.Api;
import sn.esmt.scolarite.http.EtudiantResponse;

public class InscriptionActivity extends AppCompatActivity {

    private EditText matriculeText;
    private EditText fraisText;
    private EditText nomText;
    private EditText prenomText;
    private EditText telText;
    private EditText emailText;
    private EditText passwordText;
    private Button inscrirebt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        EditText nomText = (EditText) findViewById(R.id.nomText);
        EditText prenomText = (EditText) findViewById(R.id.prenomText);
        EditText telText= (EditText) findViewById((R.id.telText)) ;
        EditText emailText = (EditText) findViewById((R.id.emailText));
        EditText passwordText= (EditText) findViewById((R.id.passwordText)) ;

        Button inscrirebt= (Button) findViewById(R.id.inscrirebt);
        inscrirebt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.137.1:8082")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Api api = retrofit.create((Api.class));
                //creation de l'objet etudiant a ajouter dans la classe
                EtudiantResponse e = new EtudiantResponse();
                e.setMat(matriculeText.getText().toString());
                e.setNom(nomText.getText().toString());
                e.setPrenom(prenomText.getText().toString());
                e.setTel(Integer.parseInt(telText.getText().toString()));

                e.setAbr(emailText.getText().toString());
                e.setFrais(Double.parseDouble(fraisText.getText().toString()));

                //Appel de l'api
                Call<EtudiantResponse> callSave = api.saveEtudiant(e);

                callSave.enqueue(new Callback<EtudiantResponse>() {
                    @Override
                    public void onResponse(Call<EtudiantResponse> call, Response<EtudiantResponse> response) {
                        Toast.makeText(InscriptionActivity.this, "Impossible d'acceder au serveur", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<EtudiantResponse> call, Throwable t) {
                            Toast.makeText(InscriptionActivity.this,"Impossible d'accéder au serveur",Toast.LENGTH_LONG).show();

                    }
                });

                if(matriculeText.getText().toString().isEmpty() || nomText.getText().toString().isEmpty() || prenomText.getText().toString().isEmpty() || emailText.getText().toString().isEmpty()){
                    Toast.makeText(InscriptionActivity.this,"Veillez remplir les champs importants.", Toast.LENGTH_LONG).show();
                }
                else {
                         openHomeActivity();
                }


            }

            private void openHomeActivity() {
                Intent intent = new Intent(InscriptionActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}