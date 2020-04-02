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
import br.com.bibliasagrada.model.Biblia;

public class AdapterBiblia extends RecyclerView.Adapter<AdapterBiblia.MyViewHolder>  {

    private List<Biblia> livros;
    private Context context;

    public AdapterBiblia(List<Biblia> livros, Context context) {
        this.livros = livros;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.biblia_detalhe,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Biblia biblia = livros.get(position);
        holder.livro.setText(biblia.getLivro());
    }


    @Override
    public int getItemCount() {
        return livros.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView livro;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            livro = itemView.findViewById(R.id.txtLivroBiblia);
        }
    }
}
