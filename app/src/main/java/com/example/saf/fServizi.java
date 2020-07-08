package com.example.saf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class fServizi extends AppCompatActivity {

    private Button deposito;
    private Button manutenzione;
    private Button ordini;
    private Button contabilita;
    private ImageView logo;
    private ImageView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_servizi);

        deposito = (Button) findViewById(R.id.button_deposito4);
        manutenzione = (Button) findViewById(R.id.button_manutenzione4);
        ordini = (Button) findViewById(R.id.button_ordini4);
        contabilita = (Button) findViewById(R.id.button_contabilità4);
        logo = (ImageView) findViewById(R.id.logo_servizi);
        user = (ImageView) findViewById(R.id.image_user);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(fServizi.this);
                adb.setTitle("Logout:");
                adb.setMessage("Sei sicuro di voler effettuare il logout?");
                adb.setNegativeButton("Annulla", null);
                adb.setPositiveButton("Esci", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent7= new Intent(fServizi.this, aLogin.class);
                        startActivity(intent7);

                    }
                });
                adb.show();
            }
        });

        deposito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione2 ();
            }
        });

        manutenzione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione3 ();
            }
        });

        ordini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione4 ();
            }
        });

        contabilita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                azione6 ();
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione7 ();
            }
        });
    }

    private void azione2 (){
        Intent intent2 = new Intent(fServizi.this, cDeposito.class);
        startActivity(intent2);
    }

    private void azione3 (){
        Intent intent3 = new Intent (fServizi.this, dManutenzione.class);
        startActivity(intent3);
    }

    private void azione4 (){
        Intent intent4 = new Intent (fServizi.this, eOrdini.class);
        startActivity(intent4);
    }


    private void azione6 (){
        Intent intent6 = new Intent (fServizi.this, gContabilita.class);
        startActivity(intent6);
    }

    private void azione7 () {
        Intent intent7 = new Intent (fServizi.this, bHomePage.class);
        startActivity(intent7);
    }
}
