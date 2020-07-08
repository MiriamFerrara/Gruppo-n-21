package com.example.saf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;


import static android.widget.AdapterView.*;

public class dRubricaManutenzione extends AppCompatActivity {

    private Button deposito1;
    private Button ordini1;
    private Button servizi1;
    private Button contabilita1;
    private ImageView immagine1;
    private ImageView logoMucca1;
    private ImageView image;
    private ListView lis;
    private ArrayAdapter adapter;
    private ImageView rimuovi;
    private ImageView telefono;
    private ImageView user;
    private static  final int i= 1;

    ArrayList<String> arr = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_rubrica_manutenzione);


        deposito1 = (Button) findViewById(R.id.button_deposito2);
        ordini1 = (Button) findViewById(R.id.button_ordini2);
        servizi1 = (Button) findViewById(R.id.button_servizi2);
        contabilita1 = (Button) findViewById(R.id.button_contabilità2);
        image = (ImageView) findViewById(R.id.image_rubrica);
        immagine1 = (ImageView) findViewById(R.id.image_aggiungi);
        logoMucca1 = (ImageView) findViewById(R.id.logo_rubrica);
        lis = (ListView) findViewById(R.id.lista);
        rimuovi = (ImageView) findViewById(R.id.image_rimuovi);
        telefono = (ImageView) findViewById(R.id.image_telefono);
        user = (ImageView) findViewById(R.id.image_user);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(dRubricaManutenzione.this);
                adb.setTitle("Logout:");
                adb.setMessage("Sei sicuro di voler effettuare il logout?");
                adb.setNegativeButton("Annulla", null);
                adb.setPositiveButton("Esci", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent7= new Intent(dRubricaManutenzione.this, aLogin.class);
                        startActivity(intent7);

                    }
                });
                adb.show();
            }
        });

        arr.add(new String("Ditta A" + "   " + "081 344 7749"));
        arr.add(new String("Ditta B" + "   " + "081 433 4012"));
        arr.add(new String("Ditta C" + "   " + "081 547 7093"));
        arr.add(new String("Ditta D" + "   " + "081 444 5023"));
        arr.add(new String("Ditta E" + "   " + "081 555 4554"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        lis.setAdapter(adapter);


        deposito1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione2();
            }
        });

        ordini1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione4();
            }
        });

        servizi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione5();
            }
        });

        contabilita1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione6();
            }
        });

        immagine1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(dRubricaManutenzione.this);
                dialog.getWindow();
                dialog.setContentView(R.layout.mydialog_rubrica);
                dialog.setCancelable(true);
                ImageView close = (ImageView) dialog.findViewById(R.id.CloseDialogImageView);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                final Button sal = (Button) dialog.findViewById(R.id.salva_in_rubrica);
                sal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextInputEditText nom = (TextInputEditText) dialog.findViewById(R.id.nome2);
                        EditText num = (EditText) dialog.findViewById(R.id.inserisci_num);
                        adapter.add(new String(nom.getText().toString() + "  " + num.getText().toString()));

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        logoMucca1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azione7();
            }
        });

        lis.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View view, final int posizione, long id) {
                rimuovi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder adb = new AlertDialog.Builder(dRubricaManutenzione.this);
                        adb.setTitle("Elimina elemento:");
                        adb.setMessage("Sei sicuro di voler eliminare " + lis.getItemAtPosition(posizione) + "?");
                        final int posizioneDaRimuovere = posizione;
                        adb.setNegativeButton("Annulla", null);
                        adb.setPositiveButton("Elimina", new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.remove(lis.getItemAtPosition(posizioneDaRimuovere));

                            }
                        });
                        adb.show();
                    }

                });


                telefono.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final AlertDialog.Builder abc = new AlertDialog.Builder(dRubricaManutenzione.this);
                        abc.setTitle("Chiama contatto:");
                        abc.setMessage("Sei sicuro di voler chiamare " + lis.getItemAtPosition(posizione) + "?");
                        final int posizioneDachiamare = posizione;
                        abc.setNegativeButton("Annulla", null);
                        abc.setPositiveButton("Chiama", new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                lis.getItemAtPosition(posizioneDachiamare);

                                if (lis.getItemAtPosition(posizioneDachiamare).toString().length() > 0) {
                                    if (ContextCompat.checkSelfPermission(dRubricaManutenzione.this,
                                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                        ActivityCompat.requestPermissions(dRubricaManutenzione.this,
                                                new String[]{Manifest.permission.CALL_PHONE}, i);
                                    } else {
                                        String dial = "tel:" + lis.getItemAtPosition(posizioneDachiamare);
                                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                                    }
                                } else {
                                    Toast.makeText(dRubricaManutenzione.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                        abc.show();
                    }


                });


            }


        });

    }



    private void azione2() {
        Intent intent2 = new Intent(dRubricaManutenzione.this, cDeposito.class);
        startActivity(intent2);
    }

    private void azione4() {
        Intent intent4 = new Intent(dRubricaManutenzione.this, eOrdini.class);
        startActivity(intent4);
    }

    private void azione5() {
        Intent intent5 = new Intent(dRubricaManutenzione.this, fServizi.class);
        startActivity(intent5);
    }

    private void azione6() {
        Intent intent6 = new Intent(dRubricaManutenzione.this, gContabilita.class);
        startActivity(intent6);
    }

    private void azione7() {
        Intent intent = new Intent(dRubricaManutenzione.this, bHomePage.class);
        startActivity(intent);
    }



}
