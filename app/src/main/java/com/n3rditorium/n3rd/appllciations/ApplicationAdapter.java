package com.n3rditorium.n3rd.appllciations;

import android.content.Context;
import android.content.Intent;
import android.content.pm.LauncherActivityInfo;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.n3rditorium.n3rd.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ApplicationAdapter
      extends RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder> {

   public class ApplicationViewHolder extends RecyclerView.ViewHolder {

      @BindView (R.id.img_icon)
      ImageView icon;
      @BindView (R.id.txt_title)
      TextView title;

      public ApplicationViewHolder(View itemView) {
         super(itemView);
         icon = (ImageView) itemView.findViewById(R.id.img_icon);
         title = (TextView) itemView.findViewById(R.id.txt_title);
      }
   }

   private final int density;
   private final List<LauncherActivityInfo> items;
   private final Picasso picasso;

   public ApplicationAdapter(Context context, ArrayList<LauncherActivityInfo> applications) {
      this.items = applications;
      this.picasso = Picasso.with(context);
      WindowManager windowManager =
            (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
      DisplayMetrics displayMetrics = new DisplayMetrics();
      windowManager.getDefaultDisplay()
            .getMetrics(displayMetrics);
      this.density = displayMetrics.densityDpi;
   }

   @Override
   public int getItemCount() {
      if (items == null) {
         return 0;
      }
      return items.size();
   }

   @Override
   public void onBindViewHolder(ApplicationViewHolder holder, int position) {
      final LauncherActivityInfo item = items.get(position);
      if (item == null) {
         return;
      }
      holder.icon.setImageDrawable(item.getIcon(density));
      holder.title.setText(item.getLabel());
      holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            v.getContext()
                  .startActivity(Intent.makeMainActivity(item.getComponentName()));
         }
      });
   }

   @Override
   public ApplicationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new ApplicationViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.drawer_app_item, parent, false));
   }
}
