package br.com.bibliasagrada.model;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.bibliasagrada.helper.DbHelper;

public class BibliaDAO {


    private SQLiteDatabase leitura;

    public BibliaDAO(Context context) {
        DbHelper helper = new DbHelper(context);
        leitura = helper.getReadableDatabase();
    }

    public List<Biblia> getListaLivros() throws SQLException {

        ArrayList<Biblia> biblias = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TAB_LIVRO + ";";


        Cursor c = leitura.rawQuery(sql,null);

        while (c.moveToNext()){
            Biblia biblia = new Biblia();

            biblia.setLivro(c.getString(c.getColumnIndex("name")));
            biblia.setBook_id(c.getString(c.getColumnIndex("book_id")));

            biblias.add(biblia);
        }

        return biblias;
    }

    public List<Biblia> getListaVerses() throws SQLException {

        ArrayList<Biblia> biblias = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TAB_VERSES + ";";


        Cursor c = leitura.rawQuery(sql,null);

        while (c.moveToNext()){
            Biblia biblia = new Biblia();

            biblia.setBook_id(c.getString(c.getColumnIndex("book_id")));
            biblia.setCapitulo(c.getString(c.getColumnIndex("chapter")));
            biblia.setVersiculo(c.getString(c.getColumnIndex("verse")));
            biblia.setTexto(c.getString(c.getColumnIndex("text")));

            biblias.add(biblia);
        }

        return biblias;
    }
}
