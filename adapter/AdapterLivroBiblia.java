package br.com.bibliasagrada.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.bibliasagrada.R;


public class AdapterLivroBiblia extends RecyclerView.Adapter<AdapterLivroBiblia.MyViewHolder> {

    private List<Integer> capitulos;
    private Context context;

    public AdapterLivroBiblia(List<Integer> capitulos, Context context) {
        this.capitulos = capitulos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.livro_biblia_detalhe,parent,false);
        return new AdapterLivroBiblia.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String i  = String.valueOf(capitulos.get(position));
        holder.num.setText(i);
    }

    @Override
    public int getItemCount() {
        return capitulos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView num;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.txtNumero);

        }
    }
}
