package com.aula.chat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aula.teste.R;
import com.aula.teste.holder.MyViewHolder;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context context;
    private List<UserModel> userModelsList;

    public UserAdapter(Context context) {
        this.context = context;
        this.userModelsList = new ArrayList<>();
    }

    public void add(UserModel userModel){
        userModelsList.add(userModel);
    }
    public void clear(){
        userModelsList.clear();
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        UserModel userModel = userModelsList.get(position);
        holder.name.setText(userModel.getUserName());
        holder.email.setText(userModel.getUserEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ChatMsgActivity.class);
                intent.putExtra("userId",userModel.getUserId());
                intent.putExtra("userName",userModel.getUserName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userModelsList.size();
    }
    public List<UserModel> getUserModelsList(){
        return userModelsList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name,email;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);

        }
    }
}
