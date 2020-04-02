package br.com.bibliasagrada.adapter;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.bibliasagrada.R;
import br.com.bibliasagrada.model.Biblia;

public class AdapterVersiculos extends RecyclerView.Adapter<AdapterVersiculos.MyViewHolder>  {

    private List<Biblia> versiculos;
    private Context context;

    public AdapterVersiculos(List<Biblia> versiculos, Context context) {
        this.versiculos = versiculos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.versiculos_detalhe,parent,false);
        return new AdapterVersiculos.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Biblia biblia = versiculos.get(position);
        holder.numVerse.setText(biblia.getVersiculo());
        holder.verse.setText(biblia.getTexto());

    }

    @Override
    public int getItemCount() {
        return versiculos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView numVerse,verse;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            numVerse = itemView.findViewById(R.id.txtNumVerse);
            verse = itemView.findViewById(R.id.txtVerse);
        }
    }
}