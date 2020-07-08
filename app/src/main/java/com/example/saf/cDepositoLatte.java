package com.example.saf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class cDepositoLatte extends AppCompatActivity {

    private Button manutenzione;
    private Button ordini;
    private Button servizi;
    private Button contabilita;
    private ImageView indietro;
    private ImageView aggiungi;


    List <Tipo> li;
    ListView listvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_deposito_latte);

        li= new ArrayList<>();
        li.add(new Tipo(R.drawable.contenitore,"Contenitore 1","1000 litri","4°C"));
        li.add(new Tipo(R.drawable.contenitore,"Contenitore 2","3000 litri","6°C"));
        li.add(new Tipo(R.drawable.contenitore,"Contenitore 3","6000 litri","3°C"));

        listvi = (ListView) findViewById(R.id.listlist);

        myAdapter adatto = new myAdapter(this, R.layout.activity_c_deposito_latte, li);

        listvi.setAdapter(adatto);


        manutenzione = (Button) findViewById(R.id.button_manutenzione12);
        ordini = (Button) findViewById(R.id.button_ordini12);
        servizi = (Button) findViewById(R.id.button_servizi12);
        contabilita = (Button) findViewById(R.id.button_contabilità12);
        indietro = (ImageView) findViewById(R.id.back);
        aggiungi = (ImageView) findViewById(R.id.image_con_aggiungi);


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

       indietro.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               azione7 ();
           }
       });

        aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog2 = new Dialog(cDepositoLatte.this);
                dialog2.getWindow();
                dialog2.setContentView(R.layout.mydialog_contenitori);
                dialog2.setCancelable(true);
                ImageView close = (ImageView) dialog2.findViewById(R.id.CloseDialogImageView);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });
                final Button sal2 = (Button) dialog2.findViewById(R.id.salva_in_contenitore);
                sal2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextInputEditText nome = (TextInputEditText) dialog2.findViewById(R.id.nome_contenitore);
                        TextInputEditText litri = (TextInputEditText) dialog2.findViewById(R.id.litri_contenitore);
                        TextInputEditText gradi= (TextInputEditText) dialog2.findViewById(R.id.gradi_contenitore);
                        li.add(new Tipo(R.drawable.contenitore, nome.getText().toString(), litri.getText().toString()+ " litri", gradi.getText().toString()+ "°C"));

                        dialog2.dismiss();
                    }
                });

                dialog2.show();
            }
        });


    }

    private void azione3 (){
        Intent intent3 = new Intent (cDepositoLatte.this, dManutenzione.class);
        startActivity(intent3);
    }

    private void azione4 (){
        Intent intent4 = new Intent (cDepositoLatte.this, eOrdini.class);
        startActivity(intent4);
    }

    private void azione5 (){
        Intent intent5 = new Intent (cDepositoLatte.this, fServizi.class);
        startActivity(intent5);
    }

    private void azione6 (){
        Intent intent6 = new Intent (cDepositoLatte.this, gContabilita.class);
        startActivity(intent6);
    }

   private void azione7 () {
        Intent intent7 = new Intent (cDepositoLatte.this, cDeposito.class);
        startActivity(intent7);
   }

}