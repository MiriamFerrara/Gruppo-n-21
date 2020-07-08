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

public class iSpese extends AppCompatActivity {

    private Button deposito;
    private Button manutenzione;
    private Button ordini;
    private Button servizi;
    private ImageView logo;
    private ListView lista;
    private ArrayAdapter<String> adapter;
    private ImageView rimuovi;
    private ImageView aggiungi;
    private ImageView user;

    ArrayList<String> arra= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_spese);

        deposito = (Button) findViewById(R.id.button_deposito7);
        manutenzione = (Button) findViewById(R.id.button_manutenzione7);
        ordini = (Button) findViewById(R.id.button_ordini7);
        servizi = (Button) findViewById(R.id.button_servizi7);
        logo = (ImageView) findViewById(R.id.logo_spese);
        lista = (ListView) findViewById(R.id.lista_spese);
        rimuovi = (ImageView) findViewById(R.id.rimuovi_spese);
        aggiungi = (ImageView) findViewById(R.id. aggiungi_spese);
        user = (ImageView) findViewById(R.id.image_user);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(iSpese.this);
                adb.setTitle("Logout:");
                adb.setMessage("Sei sicuro di voler effettuare il logout?");
                adb.setNegativeButton("Annulla", null);
                adb.setPositiveButton("Esci", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent7= new Intent(iSpese.this, aLogin.class);
                        startActivity(intent7);

                    }
                });
                adb.show();
            }
        });

        arra.add(new String("Data di scadenza:\n" + "25/09/2020\n\n" + "Nome:\n" + "Carlo Bianchi \n\n" + "Descrizione:\n" + "Consegna di 39 litri di latte\n\n " + "Importo:\n" + "€" + "497\n"));
        arra.add(new String("Data di scadenza:\n" + "15/01/2021\n\n " + "Nome:\n" + "Simone Gallo\n\n " + "Descrizione:\n" + "Consegna di 80 litri di latte\n\n " + "Importo:\n"+ "€" + "997\n"));
        arra.add(new String("Data di scadenza:\n" + "30/01/2021\n\n " + "Nome:\n" + "Michele Gatti\n\n " + "Descrizione:\n" + "Consegna di 125 litri di latte\n\n " + "Importo:\n" + "€" + "1235\n"));

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arra);
        lista.setAdapter(adapter);

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

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione6 ();
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View view, final int posizione, long id) {
                rimuovi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder adb = new AlertDialog.Builder(iSpese.this);
                        adb.setTitle("Elimina elemento:");
                        adb.setMessage("Sei sicuro di voler eliminare " + lista.getItemAtPosition(posizione) + "?");
                        final int posizioneDaRimuovere = posizione;
                        adb.setNegativeButton("Annulla", null);
                        adb.setPositiveButton("Elimina", new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.remove((String) lista.getItemAtPosition(posizioneDaRimuovere));

                            }
                        });
                        adb.show();
                    }

                });
            }


        });
        aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(iSpese.this);
                dialog.getWindow();
                dialog.setContentView(R.layout.mydialog_spesee);
                dialog.setCancelable(true);
                ImageView close = (ImageView) dialog.findViewById(R.id.CloseDialogImageView);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                final Button sal = (Button) dialog.findViewById(R.id.salva_in_spese);
                sal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextInputEditText datascadenza= (TextInputEditText) dialog.findViewById(R.id.data_scadenza);
                        TextInputEditText nome= (TextInputEditText) dialog.findViewById(R.id.nome_cliente1);
                        TextInputEditText descrizione_prodotti= (TextInputEditText) dialog.findViewById(R.id.descrizione1);
                        TextInputEditText importo= (TextInputEditText) dialog.findViewById(R.id.importo1);
                        adapter.add(new String("Data di scadenza:\n" + datascadenza.getText().toString() + "\n\n" + "Nome:\n" + nome.getText().toString() + "\n\n" + "Descrizione:\n" + descrizione_prodotti.getText().toString() + "\n\n " + "Importo:\n" + "€" + importo.getText().toString() + "\n"));
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }


    private void azione2 (){
        Intent intent2 = new Intent(iSpese.this, cDeposito.class);
        startActivity(intent2);
    }

    private void azione3 (){
        Intent intent3 = new Intent (iSpese.this, dManutenzione.class);
        startActivity(intent3);
    }

    private void azione4 (){
        Intent intent4 = new Intent (iSpese.this, eOrdini.class);
        startActivity(intent4);
    }

    private void azione5 (){
        Intent intent5 = new Intent (iSpese.this, fServizi.class);
        startActivity(intent5);
    }

    private void azione6 () {
        Intent intent6 = new Intent (iSpese.this, bHomePage.class);
        startActivity(intent6);
    }
}
