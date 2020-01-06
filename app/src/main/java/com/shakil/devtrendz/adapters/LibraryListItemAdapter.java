package com.shakil.devtrendz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.devtrendz.R;
import com.shakil.devtrendz.models.Library;
import java.util.ArrayList;

public class LibraryListItemAdapter extends RecyclerView.Adapter<LibraryListItemAdapter.ViewHolder>{
    private ArrayList<Library> libraryList;
    private Context context;
    private onItemClickListener onItemClickListener;

    public LibraryListItemAdapter(ArrayList<Library> libraryList, Context context ,onItemClickListener onItemClickListener) {
        this.libraryList = libraryList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_recycler_style_generic_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Library library = libraryList.get(position);
        holder.RepoName.setText(library.getRepoName());
        holder.RepoOwner.setText(library.getRepoOwner());
        holder.RepoLink.setText(library.getRepoLink());
        holder.NumberOfStars.setText(""+library.getNumberOfStars());
        holder.NumberOdForks.setText(""+library.getNumberOfForks());
        holder.NumberOfWatch.setText(""+library.getNumberOfWatch());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.respond(library);
            }
        });
    }

    @Override
    public int getItemCount() {
        return libraryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView RepoName , RepoOwner , RepoLink , NumberOfStars , NumberOdForks , NumberOfWatch;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            RepoName = itemView.findViewById(R.id.RepoName);
            RepoOwner = itemView.findViewById(R.id.RepoOwner);
            RepoLink = itemView.findViewById(R.id.RepoLink);
            NumberOfStars = itemView.findViewById(R.id.NumberOfStars);
            NumberOdForks = itemView.findViewById(R.id.NumberOfForks);
            NumberOfWatch = itemView.findViewById(R.id.NumberOfWatch);
            cardView = itemView.findViewById(R.id.item_card_view);
        }
    }

    public interface onItemClickListener {
        void respond(Library Library);
    }
}
