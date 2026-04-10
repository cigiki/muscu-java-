package com.example.muscu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlanningAdapter extends RecyclerView.Adapter<PlanningAdapter.ViewHolder> {

    private List<PlanningExercice> planningList;
    private Context context;

    private final String[] jours = {"", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};

    public PlanningAdapter(List<PlanningExercice> planningList, Context context) {
        this.planningList = planningList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_planning, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PlanningExercice item = planningList.get(position);
        holder.tvJour.setText(jours[item.getJour()]);
        holder.tvExercice.setText(item.getNomExercice());
    }

    @Override
    public int getItemCount() {
        return planningList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJour, tvExercice;

        public ViewHolder(View itemView) {
            super(itemView);
            tvJour = itemView.findViewById(R.id.tv_jour);
            tvExercice = itemView.findViewById(R.id.tv_exercice);
        }
    }
}