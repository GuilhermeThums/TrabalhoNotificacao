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

    public static final String CANAL_2_NOME = "Canal 2";
    public static final String CANAL_3_NOME = "Canal 3";
    public static final String CANAL_4_NOME = "Canal 4";
    public static final String CANAL_5_NOME = "Canal 5";

    int importanciaCanal2 = NotificationManager.IMPORTANCE_HIGH;
    int importanciaCanal3 = NotificationManager.IMPORTANCE_LOW;
    int importanciaCanal4 = NotificationManager.IMPORTANCE_MIN;
    int importanciaCanal5 = NotificationManager.IMPORTANCE_DEFAULT;




    @Override
    public void onCreate() {
        super.onCreate();

        criarCanaisNotificacao();
    }

    private void criarCanaisNotificacao(){
        //Verifica se a API é de nível 26 ou superior
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //Criação do canal de notificação com 3 parâmetros, ID, nome e importância já definidos anteriormente
            NotificationChannel canal1 = new NotificationChannel(CANAL_1_ID, CANAL_1_NOME, importanciaCanal1);
            canal1.setDescription("Esse é o canal 1 de notificação");
            NotificationChannel canal2 = new NotificationChannel(CANAL_2_ID, CANAL_2_NOME, importanciaCanal2);
            canal2.setDescription("Esse é o canal 2 de notificação");
            NotificationChannel canal3 = new NotificationChannel(CANAL_3_ID, CANAL_3_NOME, importanciaCanal3);
            canal3.setDescription("Esse é o canal 3 de notificação");
            NotificationChannel canal4 = new NotificationChannel(CANAL_4_ID, CANAL_4_NOME, importanciaCanal4);
            canal4.setDescription("Esse é o canal 4 de notificação");
            NotificationChannel canal5 = new NotificationChannel(CANAL_5_ID, CANAL_5_NOME, importanciaCanal5);
            canal3.setDescription("Esse é o canal 3 de notificação");

            //Chamada do gerenciador (manager) para definir de fato o canal de notificação
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(canal1);
            manager.createNotificationChannel(canal2);
            manager.createNotificationChannel(canal3);
            manager.createNotificationChannel(canal4);
            manager.createNotificationChannel(canal5);
        }
    }
}
