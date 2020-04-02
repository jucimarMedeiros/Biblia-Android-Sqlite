package br.com.bibliasagrada.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.SQLException;
import android.os.Build;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliasagrada.R;
import br.com.bibliasagrada.adapter.AdapterVersiculos;
import br.com.bibliasagrada.model.Biblia;
import br.com.bibliasagrada.model.BibliaDAO;

public class VersiculosActivity extends AppCompatActivity implements Serializable {
    private RecyclerView recyclerVerse;
    private List<Biblia> listaVersiculos = new ArrayList<>();
    private List<Biblia> capituloVersiculos = new ArrayList<>();
    private String capitulo,livroSelecionado,codLivro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versiculos);
        carregarListaVersisculos();

        recyclerVerse = findViewById(R.id.recyclerVersiculos);


        Bundle cap = getIntent().getExtras();
        capitulo = (String) cap.getSerializable("numCap");
        codLivro =  (String) cap.getSerializable("codLivro");
        livroSelecionado = (String) cap.getSerializable("livro");
        selecionarCapitulo();

        AdapterVersiculos adapterVersiculos = new AdapterVersiculos(capituloVersiculos,getApplicationContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerVerse.setLayoutManager(layoutManager);
        recyclerVerse.setHasFixedSize(true);
        recyclerVerse.setAdapter(adapterVersiculos);

        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Capítulo  "+capitulo);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void carregarListaVersisculos() throws SQLException {
        BibliaDAO bibliaDAO = new BibliaDAO(getApplicationContext());
        listaVersiculos = bibliaDAO.getListaVerses();
    }



    public void selecionarCapitulo(){
        for(int i=0; i < listaVersiculos.size();i++){
            Biblia biblia = listaVersiculos.get(i);
            if(biblia.getCapitulo().equals(capitulo) && biblia.getBook_id().equals(codLivro)){
                capituloVersiculos.add(biblia);
            }
        }
    }
}
