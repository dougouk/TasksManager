package com.dan190.manager.activity.Tasks;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dan190.manager.R;
import com.dan190.manager.activity.interfaces.OnEditTask;
import com.squareup.picasso.Picasso;

/**
 * Created by T2 on 12/30/2015.
 */
public class TaskListAdapter
        extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {
    static String[] fakeData = new String[]{
            "Un",
            "Deux",
            "Trois",
            "Quatre",
            "Cinq",
            "Six",
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_task, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i){
        final Context context = viewHolder.titleView.getContext();
        viewHolder.titleView.setText(fakeData[i]);

        Picasso.with(context)
                .load(getImageUrlForTask(i))
                .into(viewHolder.imageView);

        viewHolder.cardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((OnEditTask) context).editTask(i);
                    }
                }
        );
    }

    public static String getImageUrlForTask(long taskId){
        return ("http://lorempixel.com/600/400/abstract/?fakeId=" + taskId);
    }
    @Override
    public int getItemCount(){
        return fakeData.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView titleView;
        ImageView imageView;

        public ViewHolder(CardView card) {
            super(card);
            cardView = card;
            titleView = (TextView) card.findViewById(R.id.text1);
            imageView = (ImageView)card.findViewById(R.id.image);
        }
    }
}
