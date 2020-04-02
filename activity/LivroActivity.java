package br.com.bibliasagrada.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliasagrada.R;
import br.com.bibliasagrada.activity.VersiculosActivity;
import br.com.bibliasagrada.adapter.AdapterBiblia;
import br.com.bibliasagrada.adapter.AdapterLivroBiblia;
import br.com.bibliasagrada.model.Biblia;
import br.com.bibliasagrada.model.BibliaDAO;


public class LivroActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private String livroEscolhido;
    private String numCapitulo;
    private String codLivro;
   // private BottomNavigationView bottomNavigationView;
    private List<Integer> listaCapitulos = new ArrayList<>();
    private List<Biblia> listaLivros = new ArrayList<>();
    private Biblia biblia;
    private AdapterLivroBiblia adapterLivroBiblia;
  //  private FirebaseAuth autenticacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro_biblia);

        carregarListaLivros();

       // bottomNavigationView = findViewById(R.id.nav_bottom);

        Bundle livro = getIntent().getExtras();
        livroEscolhido = (String) livro.getSerializable("biblia");

        chamarLivro(livroEscolhido);


        recyclerView = findViewById(R.id.recycleLivroBiblia);
        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle(livroEscolhido);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






        adapterLivroBiblia = new AdapterLivroBiblia(listaCapitulos,getApplicationContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterLivroBiblia);

        recyclerView.addOnItemTouchListener(
                new br.com.nazareno.helper.RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new br.com.nazareno.helper.RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(getApplicationContext(), VersiculosActivity.class);
                                int i = position+1;
                                numCapitulo = String.valueOf(i);
                                intent.putExtra("codLivro",codLivro);
                                intent.putExtra("numCap",numCapitulo);
                              //  intent.putExtra("livro",livroEscolhido);
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
        listaLivros = bibliaDAO.getListaLivros();
    }

    public void qtdCapitulos(int cap){
        for (int i=1; i<=cap;i++){
            listaCapitulos.add(i);
        }
    }



    public void chamarLivro(String livro){
        switch (livro){
            case "Gênesis":
                qtdCapitulos(50);
                codLivro ="1";
                break;
            case "Êxodo":
                qtdCapitulos(40);
                codLivro ="2";
                break;
            case "Levítico":
                qtdCapitulos(27);
                codLivro ="3";
                break;
            case "Números":
                qtdCapitulos(36);
                codLivro ="4";
                break;
            case "Deuteronômio":
                qtdCapitulos(34);
                codLivro ="5";
                break;
            case "Josué":
                qtdCapitulos(24);
                codLivro ="6";
                break;
            case "Juízes":
                qtdCapitulos(21);
                codLivro ="7";
                break;
            case "Rute":
                qtdCapitulos(4);
                codLivro ="8";
                break;
            case "1 Samuel":
                qtdCapitulos(31);
                codLivro ="9";
                break;
            case "2 Samuel":
                qtdCapitulos(24);
                codLivro ="10";
                break;
            case "1 Reis":
                qtdCapitulos(22);
                codLivro ="11";
                break;
            case "2 Reis":
                qtdCapitulos(25);
                codLivro ="12";
                break;
            case "1 Crônicas":
                qtdCapitulos(29);
                codLivro ="13";
                break;
            case "2 Crônicas":
                qtdCapitulos(36);
                codLivro ="14";
                break;
            case "Esdras":
                qtdCapitulos(10);
                codLivro ="15";
                break;
            case "Neemias":
                qtdCapitulos(13);
                codLivro ="16";
                break;
            case "Ester":
                qtdCapitulos(10);;
                codLivro ="17";
                break;
            case "Jó":
                qtdCapitulos(42);
                codLivro ="18";
                break;
            case "Salmos":
                qtdCapitulos(150);
                codLivro ="19";
                break;
            case "Provérbios":
                qtdCapitulos(31);
                codLivro ="20";
                break;
            case "Eclesiastes":
                qtdCapitulos(12);
                codLivro ="21";
                break;
            case "Cânticos":
                qtdCapitulos(8);
                codLivro ="22";
                break;
            case "Isaías":
                qtdCapitulos(66);
                codLivro ="23";
                break;
            case "Jeremias":
                qtdCapitulos(52);
                codLivro ="24";
                break;
            case "Lamentações":
                qtdCapitulos(5);
                codLivro ="25";
                break;
            case "Ezequiel":
                qtdCapitulos(48);
                codLivro ="26";
                break;
            case "Daniel":
                qtdCapitulos(12);
                codLivro ="27";
                break;
            case "Oséias":
                qtdCapitulos(14);
                codLivro ="28";
                break;
            case "Joel":
                qtdCapitulos(3);
                codLivro ="29";
                break;
            case "Amós":
                qtdCapitulos(9);
                codLivro ="30";
                break;
            case "Obadias":
                codLivro ="31";
                qtdCapitulos(1);
                break;
            case "Jonas":
                qtdCapitulos(4);
                codLivro ="32";
                break;
            case "Miquéias":
                qtdCapitulos(7);
                codLivro ="33";
                break;
            case "Naum":
                qtdCapitulos(3);
                codLivro ="34";
                break;
            case "Habacuque":
                qtdCapitulos(3);
                codLivro ="35";
                break;
            case "Sofonias":
                qtdCapitulos(3);
                codLivro ="36";
                break;
            case "Ageu":
                qtdCapitulos(2);
                codLivro ="37";
                break;
            case "Zacarias":
                qtdCapitulos(14);
                codLivro ="38";
                break;
            case "Malaquias":
                qtdCapitulos(4);
                codLivro ="39";
                break;
            case "Mateus":
                qtdCapitulos(28);
                codLivro ="40";
                break;
            case "Marcos":
                qtdCapitulos(16);
                codLivro ="41";
                break;
            case "Lucas":
                qtdCapitulos(24);
                codLivro ="42";
                break;
            case "João":
                qtdCapitulos(21);
                codLivro ="43";
                break;
            case "Atos dos Apóstolos":
                qtdCapitulos(28);
                codLivro ="44";
                break;
            case "Romanos":
                qtdCapitulos(16);
                codLivro ="45";
                break;
            case "1 Coríntios":
                qtdCapitulos(16);
                codLivro ="46";
                break;
            case "2 Coríntios":
                qtdCapitulos(13);
                codLivro ="47";
                break;
            case "Gálatas":
                qtdCapitulos(6);
                codLivro ="48";
                break;
            case "Efésios":
                qtdCapitulos(6);
                codLivro ="49";
                break;
            case "Filipenses":
                qtdCapitulos(4);
                codLivro ="50";
                break;
            case "Colossenses":
                qtdCapitulos(4);
                codLivro ="51";
                break;
            case "1 Tessalonicenses":
                qtdCapitulos(5);
                codLivro ="52";
                break;
            case "2 Tessalonicenses":
                qtdCapitulos(3);
                codLivro ="53";
                break;
            case "1 Timóteo":
                qtdCapitulos(6);
                codLivro ="54";
                break;
            case "2 Timóteo":
                qtdCapitulos(4);
                codLivro ="55";
                break;
            case "Tito":
                qtdCapitulos(3);
                codLivro ="56";
                break;
            case "Filemom":
                codLivro ="57";
                break;
            case "Hebreus":
                qtdCapitulos(13);
                codLivro ="58";
                break;
            case "Tiago":
                qtdCapitulos(5);
                codLivro ="59";
                break;
            case "1 Pedro":
                qtdCapitulos(5);
                codLivro ="60";
                break;
            case "2 Pedro":
                qtdCapitulos(3);
                codLivro ="61";
                break;
            case "1 João":
                qtdCapitulos(5);
                codLivro ="62";
                break;
            case "2 João":
                codLivro ="63";
                qtdCapitulos(1);
                break;
            case "3 João":
                codLivro ="64";
                qtdCapitulos(1);
                break;
            case "Judas":
                codLivro ="65";
                qtdCapitulos(1);
                break;
            case "Apocalipse":
                qtdCapitulos(22);
                codLivro ="66";
                break;

        }

    }
}
