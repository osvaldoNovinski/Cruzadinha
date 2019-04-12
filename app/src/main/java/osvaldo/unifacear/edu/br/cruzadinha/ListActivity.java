package osvaldo.unifacear.edu.br.cruzadinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import osvaldo.unifacear.edu.br.cruzadinha.dao.Conexao;
import osvaldo.unifacear.edu.br.cruzadinha.dao.ResultadoDao;
import osvaldo.unifacear.edu.br.cruzadinha.entity.Resultado;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        new Conexao(getApplicationContext(),
                "jogadavelha.db",
                null,
                1);

        ListView listView = findViewById(R.id.listaResultado);

        List<Resultado> resultados = new ResultadoDao().listar();

        ArrayAdapter<Resultado> arrayAdapterResultado =
                new ArrayAdapter<Resultado>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        resultados);

        listView.setAdapter(arrayAdapterResultado);
    }

    public void voltar(View v2){
        Button btnVoltarLista = findViewById(R.id.btnVoltarLista);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
