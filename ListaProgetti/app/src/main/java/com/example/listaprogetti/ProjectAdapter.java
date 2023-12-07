package com.example.listaprogetti;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private final Project[] projects;

    public ProjectAdapter(Project[] projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mio_leyout_item, parent, false);
        return  new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.bind(projects[position]);
    }

    @Override
    public int getItemCount() {
        return projects.length;
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView description;
        private final ImageView icon;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.text_view_project_title);
            description = itemView.findViewById(R.id.text_view_project_description);
            icon = itemView.findViewById(R.id.image_view_project_icon);
        }

        public void bind(Project project) {
            name.setText(project.name);
            description.setText(project.description);
            icon.setImageResource(project.image);
        }
    }

}
