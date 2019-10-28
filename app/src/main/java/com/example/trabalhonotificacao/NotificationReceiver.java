package com.example.trabalhonotificacao;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String mensagem  = intent.getStringExtra("mensagemToast");
        Toast.makeText(context, mensagem, Toast.LENGTH_LONG).show();
    }
}
