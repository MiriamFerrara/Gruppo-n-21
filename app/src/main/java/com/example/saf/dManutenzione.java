package com.example.saf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class dManutenzione extends AppCompatActivity {

    private Button deposito;
    private Button ordini;
    private Button servizi;
    private Button contabilita;
    private ImageView immagine;
    private ImageView logoMucca;
    private ImageView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_manutenzione);

        deposito = (Button) findViewById(R.id.button_deposito2_1);
        ordini = (Button) findViewById(R.id.button_ordini2_1);
        servizi = (Button) findViewById(R.id.button_servizi2_1);
        contabilita = (Button) findViewById(R.id.button_contabilità2_1);
        immagine = (ImageView) findViewById(R.id.image_rubrica);
        logoMucca = (ImageView) findViewById(R.id.logo_manutenzione);
        user = (ImageView) findViewById(R.id.image_user);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(dManutenzione.this);
                adb.setTitle("Logout:");
                adb.setMessage("Sei sicuro di voler effettuare il logout?");
                adb.setNegativeButton("Annulla", null);
                adb.setPositiveButton("Esci", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent7= new Intent(dManutenzione.this, aLogin.class);
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

        contabilita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione6();
            }
        });

        immagine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione7();
            }
        });

        logoMucca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione8();
            }
        });
    }

    private void azione2() {
        Intent intent2 = new Intent(dManutenzione.this, cDeposito.class);
        startActivity(intent2);
    }

    private void azione4() {
        Intent intent4 = new Intent(dManutenzione.this, eOrdini.class);
        startActivity(intent4);
    }

    private void azione5() {
        Intent intent5 = new Intent(dManutenzione.this, fServizi.class);
        startActivity(intent5);
    }

    private void azione6() {
        Intent intent6 = new Intent(dManutenzione.this, gContabilita.class);
        startActivity(intent6);
    }

    private void azione7() {
        Intent intent = new Intent(dManutenzione.this, dRubricaManutenzione.class);
        startActivity(intent);
    }

    private void azione8() {
        Intent intent = new Intent(dManutenzione.this, bHomePage.class);
        startActivity(intent);

    }
}

