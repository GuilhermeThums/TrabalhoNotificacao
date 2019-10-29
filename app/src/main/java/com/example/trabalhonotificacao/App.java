package com.example.trabalhonotificacao;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    //ID do canal de notificação
    public static final String CANAL_1_ID = "canal_1";
    //Nome que irá aparecer para o usuário do canal de notificação
    public static final String CANAL_1_NOME = "Canal 1";
    //Importância do canal de notificação
    int importanciaCanal1 = NotificationManager.IMPORTANCE_HIGH;

    public static final String CANAL_2_ID = "canal_2";
    public static final String CANAL_3_ID = "canal_3";
    public static final String CANAL_4_ID = "canal_4";
    public static final String CANAL_5_ID = "canal_4";

    @Override
    public void onCreate() {
        super.onCreate();

        criarCanaisNotificacao();
    }

    private void criarCanaisNotificacao(){
        //Verifica se a API é de nível 26 ou superior
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //Criação do canal de notificação com 3 parâmetros, ID, nome e importância
//          NotificationChannel canal1 = new NotificationChannel("canal_1", "Canal 1", NotificationManager.IMPORTANCE_HIGH);
            NotificationChannel canal1 = new NotificationChannel(CANAL_1_ID, CANAL_1_NOME, importanciaCanal1);
            canal1.setDescription("Esse é o canal 1 de notificação");
            NotificationChannel canal2 = new NotificationChannel(CANAL_2_ID, "Canal 2", NotificationManager.IMPORTANCE_LOW);
            canal2.setDescription("Esse é o canal 2 de notificação");
            NotificationChannel canal3 = new NotificationChannel(CANAL_3_ID, "Canal 3", NotificationManager.IMPORTANCE_DEFAULT);
            canal3.setDescription("Esse é o canal 3 de notificação");
            NotificationChannel canal4 = new NotificationChannel(CANAL_4_ID, "Canal 4", NotificationManager.IMPORTANCE_MIN);
            canal4.setDescription("Esse é o canal 4 de notificação");
            NotificationChannel canal5 = new NotificationChannel(CANAL_5_ID, "Canal 5", NotificationManager.IMPORTANCE_DEFAULT);
            canal3.setDescription("Esse é o canal 3 de notificação");

            //Chamada do gerenciador (manager) para definir de fato o canal de notificação
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(canal1);
            manager.createNotificationChannel(canal2);
            manager.createNotificationChannel(canal3);
            manager.createNotificationChannel(canal4);
        }
    }
}
