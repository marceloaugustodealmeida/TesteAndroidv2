package com.example.santanderapp.santander.detailScreen.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.santanderapp.santander.R;
import com.example.santanderapp.santander.detailScreen.model.StatementList;

import java.text.ParseException;
import java.util.List;

import static com.example.santanderapp.santander.util.Utils.convertData;
import static com.example.santanderapp.santander.util.Utils.formatReal;

public class StatementAdapter extends RecyclerView.Adapter<StatementAdapter.MeuViewHolder> {

    private List<StatementList> ListStatement;

    public StatementAdapter(List<StatementList> statement) {
        this.ListStatement = statement;
    }

    @Override
    public MeuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_item, parent, false);

        return new MeuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MeuViewHolder holder, int position) {
        StatementList item = ListStatement.get(position);
        holder.typeAccount.setText(String.valueOf(item.title));
        try {
            holder.dateAccount.setText(convertData(String.valueOf(item.date)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.descriptionAccount.setText(String.valueOf(item.desc));
        holder.valueAccount.setText(formatReal(String.valueOf(item.value)));
    }

    @Override
    public int getItemCount() {
        return ListStatement.size();
    }


    public class MeuViewHolder extends RecyclerView.ViewHolder {
        public TextView typeAccount, dateAccount, descriptionAccount, valueAccount;

        public MeuViewHolder(View view) {
            super(view);
            typeAccount = (TextView) view.findViewById(R.id.typeAccount);
            dateAccount = (TextView) view.findViewById(R.id.dateAccount);
            descriptionAccount = (TextView) view.findViewById(R.id.descriptionAccount);
            valueAccount = (TextView) view.findViewById(R.id.valueAccount);
        }
    }

}



