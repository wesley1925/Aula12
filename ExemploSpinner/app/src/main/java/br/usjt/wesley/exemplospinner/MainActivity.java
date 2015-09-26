package br.usjt.wesley.exemplospinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerOrigem;
    Spinner spinnerDestino;
    String aOrigem;
    String aDestino;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        aOrigem = "";
        aDestino = "";

        btnOk = (Button) findViewById(R.id.botao_ok);

        spinnerOrigem = (Spinner) findViewById(R.id.dropdown_origem);
        spinnerOrigem.setOnItemSelectedListener(new OrigemSelecionado());


        spinnerDestino = (Spinner) findViewById(R.id.dropdown_destino);
        spinnerDestino.setOnItemSelectedListener(new DestinoSelecionada());


    }

    private class OrigemSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            aOrigem = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class DestinoSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            aDestino = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    // constante static para identificar a mensagem
    public final static String ORIGEM = "br.usjt.ORIGEM";
    public final static String DESTINO = "br.usjt.DESTINO";

    //será chamado quando o usuário clicar em enviar
    public void consultarVoos(View view) {

        String passarOrigem = this.aOrigem.equals("Escolha o aeroporto") ? "" : aOrigem;
        String passarDestino = this.aDestino.equals("Escolha o aeroporto") ? "" : aDestino;

        Intent intent = new Intent(this, ListaVooActivity.class);
        intent.putExtra(DESTINO, passarDestino);
        intent.putExtra(ORIGEM, passarOrigem);
        startActivity(intent);
    }
}