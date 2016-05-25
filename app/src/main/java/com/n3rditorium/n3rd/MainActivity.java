package com.n3rditorium.n3rd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.n3rditorium.n3rd.appllciations.ApplicationControlller;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

   private ApplicationControlller controlller;

   @SuppressWarnings ("unused")
   @OnClick (R.id.btn_applications)
   public void openApplicationDrawer() {
      startActivity(AppDrawerActivity.getIntent(this));
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      ButterKnife.bind(this);
      controlller = new ApplicationControlller(getApplicationContext());

      findViewById(R.id.btn_applications).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            openApplicationDrawer();
         }
      });
   }
}
