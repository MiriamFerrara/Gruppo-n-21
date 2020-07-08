package com.example.saf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class gContabilita extends AppCompatActivity {

    private Button deposito;
    private Button manutenzione;
    private Button ordini;
    private Button servizi;
    private Button fatture;
    private Button spese;
    private ImageView logo;
    private ImageView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_contabilita);

        deposito = (Button) findViewById(R.id.button_deposito5);
        manutenzione = (Button) findViewById(R.id.button_manutenzione5);
        ordini = (Button) findViewById(R.id.button_ordini5);
        servizi = (Button) findViewById(R.id.button_servizi5);
        fatture = (Button) findViewById(R.id.fatturato);
        spese = (Button) findViewById(R.id.spese);
        logo = (ImageView) findViewById(R.id.logo_contabilita);
        user = (ImageView) findViewById(R.id.image_user);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(gContabilita.this);
                adb.setTitle("Logout:");
                adb.setMessage("Sei sicuro di voler effettuare il logout?");
                adb.setNegativeButton("Annulla", null);
                adb.setPositiveButton("Esci", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent7= new Intent(gContabilita.this, aLogin.class);
                        startActivity(intent7);

                    }
                });
                adb.show();
            }
        });

        deposito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione2();
            }
        });

        manutenzione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione3();
            }
        });

        ordini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione4();
            }
        });

        servizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione5();
            }
        });

        fatture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione6 ();
            }
        });

        spese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione7 ();
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione8 ();
            }
        });
    }

        private void azione2 (){
            Intent intent2 = new Intent(gContabilita.this, cDeposito.class);
            startActivity(intent2);
        }

        private void azione3 (){
            Intent intent3 = new Intent (gContabilita.this, dManutenzione.class);
            startActivity(intent3);
        }

        private void azione4 (){
            Intent intent4 = new Intent (gContabilita.this, eOrdini.class);
            startActivity(intent4);
        }

        private void azione5 (){
            Intent intent5 = new Intent (gContabilita.this, fServizi.class);
            startActivity(intent5);
        }

        private void azione6 (){
        Intent intent6 = new Intent(gContabilita.this, hFatture.class);
        startActivity(intent6);

        }

        private void azione7 () {
        Intent intent7 = new Intent(gContabilita.this, iSpese.class);
        startActivity(intent7);

        }

        private void azione8 (){
        Intent intent8 = new Intent (gContabilita.this, bHomePage.class);
        startActivity(intent8);
        }


    }
