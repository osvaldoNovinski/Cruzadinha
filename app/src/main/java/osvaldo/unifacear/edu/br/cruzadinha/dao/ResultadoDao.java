package osvaldo.unifacear.edu.br.cruzadinha.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import osvaldo.unifacear.edu.br.cruzadinha.entity.Jogada;
import osvaldo.unifacear.edu.br.cruzadinha.entity.Resultado;

/**
 * Created by osval on 08/03/2019.
 */

public class ResultadoDao {

    SQLiteDatabase conn = Conexao.getInstance();

    public void inserir(Resultado resultado) {
        ContentValues values = new ContentValues();
        values.put("ganhador",resultado.isGanhador());


        conn.insert("resultado",
                null,
                values);
    }

    public List<Resultado> listar() {
        Cursor c = conn.query("resultado",
                new String[] {"id","ganhador"},
                null,
                null,
                null,
                null,
                "id asc");

        List<Resultado> resultados = new ArrayList<Resultado>();
        if (c.moveToFirst()) {
            do {
                Resultado resultado = new Resultado();
                resultado.setId(c.getInt(c.getColumnIndex("id")));
                resultado.setGanhador(c.getInt(c.getColumnIndex("ganhador"))==1);
                resultados.add(resultado);
            } while (c.moveToNext());
        }

        return resultados;
    }
}
