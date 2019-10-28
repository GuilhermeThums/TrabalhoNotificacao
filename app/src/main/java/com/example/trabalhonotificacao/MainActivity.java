package com.example.trabalhonotificacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.trabalhonotificacao.App.CANAL_1_ID;
import static com.example.trabalhonotificacao.App.CANAL_2_ID;
import static com.example.trabalhonotificacao.App.CANAL_3_ID;
import static com.example.trabalhonotificacao.App.CANAL_4_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;

    private EditText edtTitulo;
    private EditText edtMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        edtTitulo = findViewById(R.id.edtTitulo);
        edtMensagem = findViewById(R.id.edtMensagem);

    }

    public void enviarCanal1(View v){
        String titulo = edtTitulo.getText().toString();
        String mensagem = edtMensagem.getText().toString();

        Intent atividadeIntent = new Intent(this, MainActivity.class);
        PendingIntent conteudoIntent = PendingIntent.getActivity(this, 0, atividadeIntent, 0);

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("mensagemToast", mensagem);
        PendingIntent acaoIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notificacao = new NotificationCompat.Builder(this, CANAL_1_ID)
                .setSmallIcon(R.drawable.ic_um)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC) //Define se a notificação será exibida na tela de bloqueio
                .setPriority(NotificationCompat.PRIORITY_HIGH)  //Define a prioridade da notificação em APIs inferiores a 26

                //.setOnlyAlertOnce(true)   //Faz com que a notificação só seja disruptiva uma vez

                .setContentIntent(conteudoIntent)

                .addAction(R.mipmap.ic_launcher, "Toast", acaoIntent)

                //.setAutoCancel(true)        //Quando a notificação for selecionada, será liberada da gaveta de notificações

                .build();   //Constrói a notificação
        //Emite a notificação que foi construida. O id serve para atualizar a notificação existente sem criar outra notificação
        notificationManager.notify(1, notificacao);

    }
    public void enviarCanal2(View v){
        String titulo = edtTitulo.getText().toString();
        String mensagem = edtMensagem.getText().toString();

        Intent atividadeIntent = new Intent(this, MainActivity.class);
        PendingIntent conteudoIntent = PendingIntent.getActivity(this, 0, atividadeIntent, 0);

        Notification notificacao = new NotificationCompat.Builder(this, CANAL_2_ID)
                .setSmallIcon(R.drawable.ic_dois)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setVisibility(NotificationCompat.VISIBILITY_PRIVATE) //Define se a notificação será exibida na tela de bloqueio
                .setPriority(NotificationCompat.PRIORITY_LOW)  //Define a prioridade da notificação em APIs inferiores a 26

                //.setContentIntent(conteudoIntent)

                .setColor(Color.BLUE)

                //.setAutoCancel(true)        //Quando a notificação for selecionada, será liberada da gaveta de notificações
                .build();
        notificationManager.notify(2, notificacao);

    }
    public void enviarCanal3(View v){
        String titulo = edtTitulo.getText().toString();
        String mensagem = edtMensagem.getText().toString();

        Intent atividadeIntent = new Intent(this, MainActivity.class);
        PendingIntent conteudoIntent = PendingIntent.getActivity(this, 0, atividadeIntent, 0);

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("mensagemToast", mensagem);
        PendingIntent acaoIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap iconeGrande = BitmapFactory.decodeResource(getResources(), R.drawable.ic_mailicon);

        Notification notificacao = new NotificationCompat.Builder(this, CANAL_3_ID)
                .setSmallIcon(R.drawable.ic_tres)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setLargeIcon(iconeGrande)
                .setLargeIcon(iconeGrande)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(mensagem)
                        .setBigContentTitle("Título expandido")
                        .setSummaryText("O texto expandido é:"))  //Em e-mails por exemplo é o endereço de em-ail.
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC) //Define se a notificação será exibida na tela de bloqueio
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)  //Define a prioridade da notificação em APIs inferiores a 26
                .setOnlyAlertOnce(true)   //Faz com que a notificação só seja disruptiva uma vez
                .setContentIntent(conteudoIntent)
                .addAction(R.mipmap.ic_launcher, "Toast", acaoIntent)
                .setAutoCancel(true)        //Quando a notificação for selecionada, será liberada da gaveta de notificações

                .build();   //Constrói a notificação
        //Emite a notificação que foi construida. O id serve para atualizar a notificação existente sem criar outra notificação
        notificationManager.notify(3, notificacao);


    }
    public void enviarCanal4(View v){
        String titulo = edtTitulo.getText().toString();
        String mensagem = edtMensagem.getText().toString();

        Notification notificacao = new NotificationCompat.Builder(this, CANAL_4_ID)
                .setSmallIcon(R.drawable.ic_quatro)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Essa é a linha 1")
                        .addLine("Essa é a linha 2")
                        .addLine("Essa é a linha 3")
                        .addLine("Essa é a linha 4")
                        .addLine("Essa é a linha 5")
                        .addLine("Essa é a linha 6")
                        .addLine("Essa é a linha 7")
                        .setBigContentTitle("Título expandido")
                        .setSummaryText("O texto expandido é: "))
                .setPriority(NotificationCompat.PRIORITY_MIN)
                .build();

        notificationManager.notify(4, notificacao);


    }
}