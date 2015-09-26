package br.usjt.wesley.exemplospinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.util.TreeSet;



public class ListaVooActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voos);

        Especialista especialista = new Especialista();
        //pega a mensagem do intent
        Intent intent = getIntent();
        String origem = intent.getStringExtra(MainActivity.ORIGEM);
        String destino = intent.getStringExtra(MainActivity.DESTINO);

        TreeSet<Voo> lista = especialista.listarVoos(origem, destino);

        //cria o texto da view
        TextView textView = (TextView) findViewById(R.id.txt_lista_voo);
        String message = "";
        for(Voo voo : lista){
            message += voo.toString() + "\n";
        }
        if(message.length() == 0) {
            message = "Nada encontrado";
            textView.setLines(3);
        } else {
            textView.setLines(lista.size());
        }
        textView.setText(message);
    }

}
