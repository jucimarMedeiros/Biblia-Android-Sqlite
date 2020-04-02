package br.com.bibliasagrada.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliasagrada.R;
import br.com.bibliasagrada.adapter.AdapterBiblia;
import br.com.bibliasagrada.model.Biblia;
import br.com.bibliasagrada.model.BibliaDAO;

public class MainActivity extends AppCompatActivity implements Serializable {

    private RecyclerView recyclerBiblia;
    private List<Biblia> listaBiblia = new ArrayList<>();

    private Biblia selecionarBibila;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Bíblia Sagrada");

        recyclerBiblia = findViewById(R.id.recyclerBiblia);
        carregarListaLivros();
        AdapterBiblia adapterBiblia = new AdapterBiblia(listaBiblia,getApplicationContext());


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerBiblia.setLayoutManager(layoutManager);
        recyclerBiblia.setHasFixedSize(true);
        recyclerBiblia.setAdapter(adapterBiblia);

        recyclerBiblia.addOnItemTouchListener(
                new br.com.nazareno.helper.RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerBiblia,
                        new br.com.nazareno.helper.RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                selecionarBibila = listaBiblia.get(position);
                                Biblia b = selecionarBibila;
                                Intent intent = new Intent(getApplicationContext(), LivroActivity.class);
                                intent.putExtra("biblia",b.getLivro());
                                intent.putExtra("posicao",position);
                                startActivity(intent);
                                overridePendingTransition(0,0);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }



    public void carregarListaLivros() throws SQLException {
        BibliaDAO bibliaDAO = new BibliaDAO(getApplicationContext());
        listaBiblia = bibliaDAO.getListaLivros();
    }
}
