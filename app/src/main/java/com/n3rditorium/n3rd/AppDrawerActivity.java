package com.n3rditorium.n3rd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.n3rditorium.n3rd.appllciations.ApplicationAdapter;
import com.n3rditorium.n3rd.appllciations.ApplicationControlller;

import butterknife.ButterKnife;

public class AppDrawerActivity extends AppCompatActivity {

   public static Intent getIntent(Context context) {
      Intent intent = new Intent(context, AppDrawerActivity.class);
      return intent;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.app_drawer_activity);

      ApplicationControlller controller = new ApplicationControlller(this);
      RecyclerView recyclerView = ButterKnife.findById(this, R.id.grid_applciations);
      recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
      recyclerView.setAdapter(new ApplicationAdapter(this, controller.getApplications()));
   }
}
