package com.reza.daftarbuku;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListBukuAdapter extends RecyclerView.Adapter<ListBukuAdapter.ListViewHolder> {

    private ArrayList<Buku> listBuku;
    public ItemClickListener itemClickListener;

    public interface ItemClickListener {
        void selectedItem(Buku buku);
    }

    public ListBukuAdapter(ArrayList<Buku> list, ItemClickListener itemClickListener) {
        this.listBuku = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Buku buku = listBuku.get(position);
        holder.imgPhoto.setImageResource(buku.getPhoto());
        holder.tvName.setText(buku.getName());
        holder.tvDescription.setText(buku.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.selectedItem(buku);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBuku.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }



}