package com.example.api_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.ViewHolder> {

    ArrayList<Users> users;
    Context context;

    public Recycler_Adapter(Context ct, ArrayList<Users> users_array){
        users = users_array;
        context = ct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rec_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text1.setText(users.get(position).getLname());
        holder.text2.setText(users.get(position).getFname());
        holder.text3.setText(users.get(position).getEmail());
        Picasso.get().load(users.get(position).getImg_url()).into(holder.img1);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView text1,text2,text3;
        ImageView img1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.fname);
            text2 = itemView.findViewById(R.id.lname);
            text3 = itemView.findViewById(R.id.email);
            img1 = itemView.findViewById(R.id.avatar);
        }
    }
}
