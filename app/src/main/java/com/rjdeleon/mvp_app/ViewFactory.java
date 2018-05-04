package com.rjdeleon.mvp_app;

import android.content.Context;
import android.content.Intent;

import com.rjdeleon.mvp_app.Modules.DNCAList.DNCAListActivity;
import com.rjdeleon.mvp_app.Modules.NewForm.NewFormActivity;

public class ViewFactory {

    public static void startDNCAListActivity(Context context) {
        Intent intent = new Intent(context, DNCAListActivity.class);
        context.startActivity(intent);
    }

    public static void startNewFormActivity(Context context) {
        Intent intent = new Intent(context, NewFormActivity.class);
        context.startActivity(intent);
    }

}
