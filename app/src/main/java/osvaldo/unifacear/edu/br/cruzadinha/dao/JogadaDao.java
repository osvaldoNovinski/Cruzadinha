package osvaldo.unifacear.edu.br.cruzadinha.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import osvaldo.unifacear.edu.br.cruzadinha.entity.Jogada;

/**
 * Created by osval on 01/03/2019.
 */

public class JogadaDao {

    SQLiteDatabase conn = Conexao.getInstance();

    public void inserir(Jogada jogada) {
        ContentValues values = new ContentValues();
        values.put("posicao",jogada.getPosicao());
        values.put("jogada",jogada.getJogada());

        conn.insert("jogada",
                null,
                values);
    }

    public void alterar(Jogada jogada) {

    }

    public void excluir (Jogada jogada) {
        SQLiteDatabase db = Conexao.getInstance();
        db.execSQL("DELETE FROM jogada"); //delete all rows in a table
       // db.close();

    }



    public List<Jogada> listar() {
        Cursor c = conn.query("jogada",
                new String[] {"id","posicao","jogada"},
                null,
                null,
                null,
                null,
                "id asc");

        List<Jogada> jogadas = new ArrayList<Jogada>();
        if (c.moveToFirst()) {
            do {
                Jogada jogada = new Jogada();
                jogada.setId(c.getInt(c.getColumnIndex("id")));
                jogada.setPosicao(c.getInt(c.getColumnIndex("posicao")));
                jogada.setJogada(c.getInt(c.getColumnIndex("jogada")) == 1);
                jogadas.add(jogada);
            } while (c.moveToNext());
        }

        return jogadas;
    }

}
