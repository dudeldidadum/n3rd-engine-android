package com.n3rditorium.n3rd.appllciations;

import android.content.Context;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.LauncherApps;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Kyp on 25.05.16.
 */
public class ApplicationControlller {

   private final Context context;

   public ApplicationControlller(Context context) {
      this.context = context;
   }

   public ArrayList<LauncherActivityInfo> getApplications() {
      LauncherApps launcherApps =
            (LauncherApps) context.getSystemService(Context.LAUNCHER_APPS_SERVICE);
      ArrayList<LauncherActivityInfo> apps =
            (ArrayList<LauncherActivityInfo>) launcherApps.getActivityList(null,
                  android.os.Process.myUserHandle());
      int i = 0;
      for (LauncherActivityInfo app : apps) {
         Log.i(this.getClass()
               .getSimpleName(), "#" + i++ + " - " + app.getName());
      }
      return apps;
   }
}
