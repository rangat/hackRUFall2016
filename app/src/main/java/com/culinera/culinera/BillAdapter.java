package com.culinera.culinera;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.List;

/**
 * Created by Arjun Bansil on 10/23/2016.
 */

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillViewHolder> {

    private List<BillInfo> list;

    public BillAdapter(List<BillInfo> l){
        this.list = l;
    }

    @Override
    public int getItemCount(){
        return this.list.size();
    }

    @Override
    public void onBindViewHolder(BillViewHolder b, int i){
        BillInfo bill = list.get(i);
        b.dOb.setText("Date of Bill: " + bill.getDate());
        b.cham.setText("Chambers: " + bill.getChamber());
        b.sentence.setText(bill.getContext());
        b.yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        b.no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public BillViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bill_card, viewGroup, false);
        return new BillViewHolder(itemView);
    }


    public static class BillViewHolder extends RecyclerView.ViewHolder{
        protected TextView dOb, cham, sentence;
        protected Button yes, no;

        public BillViewHolder(View v){
            super(v);
            dOb = (TextView)v.findViewById(R.id.DoB);
            cham = (TextView)v.findViewById(R.id.chambers);
            sentence = (TextView)v.findViewById(R.id.CoB);
            yes = (Button)v.findViewById(R.id.yes_vote);
            no = (Button)v.findViewById(R.id.no_vote);

        }
    }
}
