package com.example.saf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class eOrdini extends AppCompatActivity {

    private Button deposito;
    private Button manutenzione;
    private Button servizi;
    private Button contabilita;
    private ArrayAdapter<String> adapter;
    private ListView lista;
    private ImageView rimuovi;
    private ImageView aggiug;
    private ImageView logo;
    private ImageView user;


    ArrayList<String> ordini= new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_ordini);

        deposito = (Button) findViewById(R.id.button_deposito3);
        manutenzione = (Button) findViewById(R.id.button_manutenzione3);
        servizi = (Button) findViewById(R.id.button_servizi3);
        contabilita = (Button) findViewById(R.id.button_contabilità3);
        lista = (ListView) findViewById(R.id.ordini_lista);
        rimuovi = (ImageView) findViewById(R.id.rimuovi_ordine);
        aggiug = (ImageView) findViewById(R.id.aggiungi_ordine);
        logo = (ImageView) findViewById(R.id.logo_ordini);
        user = (ImageView) findViewById(R.id.image_user);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(eOrdini.this);
                adb.setTitle("Logout:");
                adb.setMessage("Sei sicuro di voler effettuare il logout?");
                adb.setNegativeButton("Annulla", null);
                adb.setPositiveButton("Esci", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent7= new Intent(eOrdini.this, aLogin.class);
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

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione7 ();
            }
        });


        ordini.add(new String("Nome Cliente\n" + "Carlo Savarese\n\n" + "Prodotti/Quantità\n" + "Mozzarella da 1Kg,\nTreccia da 600g,\nProvola da 500g\n\n" +"Data Consegna\n" + "25/05/2020\n"));
        ordini.add(new String("Nome Cliente\n" + "Gennaro De Luca\n\n" + "Prodotti/Quantità\n" + "Mozzarella da 1Kg\n\n" +"Data Consegna\n" + "15/05/2020\n"));
        ordini.add(new String("Nome Cliente\n" + "Rossella Rosso\n\n" + "Prodotti/Quantità\n" +  "Ricotta da 500g\n\n" +"Data Consegna\n" +  "16/05/2020\n"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ordini);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                rimuovi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder rim= new AlertDialog.Builder(eOrdini.this);
                        rim.setTitle("Elimina Ordine:");
                        rim.setMessage("Sei sicuro di voler eliminare "+ lista.getItemAtPosition(position) + "?");
                        final int posizioneDaRimuovere = position;
                        rim.setNegativeButton("Annulla", null);
                        rim.setPositiveButton("Elimina", new AlertDialog.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                           adapter.remove((String) lista.getItemAtPosition(posizioneDaRimuovere));
                            }
                        });
                        rim.show();
                    }
                });
            }
        });

        aggiug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(eOrdini.this);
                dialog.getWindow();
                dialog.setContentView(R.layout.my_dialog_ordini);
                dialog.setCancelable(true);
                ImageView close = (ImageView) dialog.findViewById(R.id.CloseDialogImageView);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                final Button sal = (Button) dialog.findViewById(R.id.salva_ordini);
                sal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextInputEditText nomec= (TextInputEditText) dialog.findViewById(R.id.nome_cliente);
                        TextInputEditText prodotti= (TextInputEditText) dialog.findViewById(R.id.prodotti1);
                        TextInputEditText data= (TextInputEditText) dialog.findViewById(R.id.data1);
                        adapter.add(new String("Nome Cliente\n" + nomec.getText().toString()+ "\n\n"
                        +"Prodotti/Qualità\n" + prodotti.getText().toString() + "\n\n" + "Data Consegna\n" +  data.getText().toString()+ "\n"));
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


    }


    private void azione2 (){
        Intent intent2 = new Intent(eOrdini.this, cDeposito.class);
        startActivity(intent2);
    }

    private void azione3 (){
        Intent intent3 = new Intent (eOrdini.this, dManutenzione.class);
        startActivity(intent3);
    }

    private void azione5 (){
        Intent intent5 = new Intent (eOrdini.this, fServizi.class);
        startActivity(intent5);
    }

    private void azione6 (){
        Intent intent6 = new Intent (eOrdini.this, gContabilita.class);
        startActivity(intent6);
    }

    private void azione7 () {
        Intent intent7 = new Intent (eOrdini.this, bHomePage.class);
        startActivity(intent7);
    }
}
