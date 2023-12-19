package org.nguyen.recyclerviewexamen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Integer> numberList;

    public MyAdapter(List<Integer> numberList) {
        this.numberList = numberList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final int number = numberList.get(position);
        holder.textViewNumber.setText(String.valueOf(number));
        holder.buttonDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Double the value when the button is clicked
                numberList.set(position, number * 2);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return numberList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNumber;
        Button buttonDouble;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumber = itemView.findViewById(R.id.textViewNumber);
            buttonDouble = itemView.findViewById(R.id.buttonDouble);
        }
    }
}