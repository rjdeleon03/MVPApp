package com.cpu.quikdata;

import android.content.Context;
import android.content.Intent;

import com.cpu.quikdata.Modules.DNCAList.DNCAListActivity;
import com.cpu.quikdata.Modules.NewDnca.NewDncaActivity;

public class ViewFactory {

    public static void startDNCAListActivity(Context context) {
        Intent intent = new Intent(context, DNCAListActivity.class);
        context.startActivity(intent);
    }

    public static void startNewDncaActivity(Context context) {
        Intent intent = new Intent(context, NewDncaActivity.class);
        context.startActivity(intent);
    }

}
