package com.example.task.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.R;
import com.example.task.UserModel;
import com.example.task.databinding.ItemAllUsersBinding;

import java.util.ArrayList;
import java.util.Locale;


public class AllUsersAdapter extends RecyclerView.Adapter<AllUsersAdapter.MyViewHolder> {
    ArrayList<UserModel> items;
    Context context;

    public AllUsersAdapter(ArrayList<UserModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ItemAllUsersBinding itemAdBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_all_users, viewGroup, false);
        itemAdBinding.setModel(items.get(i));
        return new MyViewHolder(itemAdBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder mViewHolder, final int i) {
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
