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

public class hFatture extends AppCompatActivity {

    private Button deposito;
    private Button manutenzione;
    private Button ordini;
    private Button servizi;
    private ImageView logo;
    private ListView lista;
    private ArrayAdapter<String> adapter;
    private ImageView elimina;
    private ImageView aggiungi;
    private ImageView user;

    ArrayList<String> array = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_fatture);

        deposito = (Button) findViewById(R.id.button_deposito6);
        manutenzione = (Button) findViewById(R.id.button_manutenzione6);
        ordini = (Button) findViewById(R.id.button_ordini6);
        servizi = (Button) findViewById(R.id.button_servizi6);
        logo = (ImageView) findViewById(R.id.logo_fatture);
        lista = (ListView) findViewById(R.id.lista_fatturato);
        elimina = (ImageView) findViewById(R.id.elimina_fattura);
        aggiungi = (ImageView) findViewById(R.id.aggiungi_fattura);
        user = (ImageView) findViewById(R.id.image_user);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(hFatture.this);
                adb.setTitle("Logout:");
                adb.setMessage("Sei sicuro di voler effettuare il logout?");
                adb.setNegativeButton("Annulla", null);
                adb.setPositiveButton("Esci", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent7= new Intent(hFatture.this, aLogin.class);
                        startActivity(intent7);

                    }
                });
                adb.show();
            }
        });

        array.add(new String("Data:\n" + "23/05/2020\n\n" + "Nome:\n" + "Givanni Smith\n\n" + "Descrizione:\n" + "Venduto 1Kg di mozzarelle\n\n" + "Importo:\n" + "€" + "20.0\n"));
        array.add(new String("Data:\n" + "23/09/2019\n\n" + "Nome:\n" + "Patrizia Rossi\n\n" + "Descrizione:\n" + "Venduto 1Kg di ricotta\n\n" + "Importo:\n" + "€" + " 15.00\n"));
        array.add(new String("Data:\n" + "23/01/2020\n\n" + "Nome:\n" + "Giulia Bianchi\n\n" + "Descrizione:\n" + "Venduto 500g di treccia di mozzarella DOC\n\n" + "Importo:\n" + "€" + " 5.00\n"));

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
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
                elimina.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder adb = new AlertDialog.Builder(hFatture.this);
                        adb.setTitle("Elimina elemento:");
                        adb.setMessage("Sei sicuro di voler eliminare" + lista.getItemAtPosition(posizione) + "?");
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
                final Dialog dialog = new Dialog(hFatture.this);
                dialog.getWindow();
                dialog.setContentView(R.layout.mydialog_fatturato);
                dialog.setCancelable(true);
                ImageView close = (ImageView) dialog.findViewById(R.id.CloseDialogImageView);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                final Button sal = (Button) dialog.findViewById(R.id.salva_in_fatturato);
                sal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextInputEditText data= (TextInputEditText) dialog.findViewById(R.id.data_fattura1);
                        TextInputEditText nome= (TextInputEditText) dialog.findViewById(R.id.nome_cliente);
                        TextInputEditText descrizione= (TextInputEditText) dialog.findViewById(R.id.descrizione0);
                        TextInputEditText importo= (TextInputEditText) dialog.findViewById(R.id.importo0);
                        adapter.add(new String("Data:\n" + data.getText().toString() + "\n\n" + "Nome:\n" + nome.getText().toString() + "\n\n" + "Descrizione:\n" + descrizione.getText().toString() + "\n\n" + "Importo:\n" + "€" + importo.getText().toString() + "\n"));
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


    }

    private void azione2 (){
        Intent intent2 = new Intent(hFatture.this, cDeposito.class);
        startActivity(intent2);
    }

    private void azione3 (){
        Intent intent3 = new Intent (hFatture.this, dManutenzione.class);
        startActivity(intent3);
    }

    private void azione4 (){
        Intent intent4 = new Intent (hFatture.this, eOrdini.class);
        startActivity(intent4);
    }

    private void azione5 (){
        Intent intent5 = new Intent (hFatture.this, fServizi.class);
        startActivity(intent5);
    }

    private void azione6 (){
        Intent intent6 = new Intent (hFatture.this, bHomePage.class);
        startActivity(intent6);
    }
}
