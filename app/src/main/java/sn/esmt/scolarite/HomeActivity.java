package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button inscrire=(Button) findViewById(R.id.inscrirebt);
        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this, InscriptionActivity.class);
                startActivity(intent);

            }
        });

        Button visualiser=(Button) findViewById(R.id.visualiserbt);
        visualiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this, ListeEtudiantActivity.class);
                startActivity(intent);
                startActivity(intent);
                startActivity(intent);
            }
        });
    }
}