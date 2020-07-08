package com.example.saf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class bHomePage extends AppCompatActivity {

    private Button deposito;
    private Button manutenzione;
    private Button ordini;
    private Button servizi;
    private Button contabilita;
    private ImageView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_home_page);

    deposito = (Button) findViewById(R.id.button_deposito);
    manutenzione = (Button) findViewById(R.id.button_manutenzione);
    ordini = (Button) findViewById(R.id.button_ordini);
    servizi = (Button) findViewById(R.id.button_servizi);
    contabilita = (Button) findViewById(R.id.button_contabilità);
    user = (ImageView) findViewById(R.id.image_user);

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

    servizi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          azione5 ();
        }
    });

    contabilita.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v){
            azione6 ();
        }
    });

    user.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder adb = new AlertDialog.Builder(bHomePage.this);
            adb.setTitle("Logout:");
            adb.setMessage("Sei sicuro di voler effettuare il logout?");
            adb.setNegativeButton("Annulla", null);
            adb.setPositiveButton("Esci", new AlertDialog.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent7= new Intent(bHomePage.this, aLogin.class);
                    startActivity(intent7);

                }
            });
            adb.show();
        }
    });
    }

    private void azione2 (){
        Intent intent2 = new Intent(bHomePage.this, cDeposito.class);
        startActivity(intent2);
    }

    private void azione3 (){
        Intent intent3 = new Intent (bHomePage.this, dManutenzione.class);
        startActivity(intent3);
    }

    private void azione4 (){
        Intent intent4 = new Intent (bHomePage.this, eOrdini.class);
        startActivity(intent4);
    }

    private void azione5 (){
        Intent intent5 = new Intent (bHomePage.this, fServizi.class);
        startActivity(intent5);
    }

    private void azione6 (){
        Intent intent6 = new Intent (bHomePage.this, gContabilita.class);
        startActivity(intent6);
    }

}
