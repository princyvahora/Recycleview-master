package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Recyadapter extends RecyclerView.Adapter<Recyadapter.ViewHolder>{

    private ArrayList<Pokemon> pokearray;
    private Context c;
    private View.OnClickListener pokelistener;

    public Recyadapter(ArrayList<Pokemon> pokearray, Context c) {
        this.pokearray = pokearray;
        this.c = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(c).asBitmap().load(pokearray.get(position).getPimg()).into(holder.imgv);
        holder.txtv.setText(pokearray.get(position).getPname());

    }
public void setOnClickListener(View.OnClickListener clickListener) {


    pokelistener = clickListener;
}
    @Override
    public int getItemCount() {
        return pokearray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView imgv;
        TextView txtv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgv = itemView.findViewById(R.id.imgv_poke);
            txtv = itemView.findViewById(R.id.txt_pkname);

itemView.setTag(this);
itemView.setOnClickListener(pokelistener);

        }
    }
}
