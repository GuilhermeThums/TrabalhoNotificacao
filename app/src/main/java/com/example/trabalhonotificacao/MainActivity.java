package com.example.trabalhonotificacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import static com.example.trabalhonotificacao.App.CANAL_1_ID;
import static com.example.trabalhonotificacao.App.CANAL_2_ID;
import static com.example.trabalhonotificacao.App.CANAL_3_ID;
import static com.example.trabalhonotificacao.App.CANAL_4_ID;
import static com.example.trabalhonotificacao.App.CANAL_5_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;

    private TextView respostaNoti;
    private EditText edtTitulo;
    private EditText edtMensagem;
    String KEY_REPLY = "key_reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        edtTitulo = findViewById(R.id.edtTitulo);
        edtMensagem = findViewById(R.id.edtMensagem);
        respostaNoti = findViewById(R.id.respostaNoti);

    }

    public void enviarNotificacaoVazia(View v){
        String titulo = edtTitulo.getText().toString();
        String mensagem = edtMensagem.getText().toString();
        //Declara todos os componentes que fazem parte da notificação
        Notification notificacao = new NotificationCompat.Builder(this, CANAL_1_ID)
                .setSmallIcon(R.drawable.ic_um) //Define o ícone pequeno
                .setContentTitle(titulo)    //Define o título
                .setContentText(mensagem)   //Define o texto
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)    //Define se a notificação será exibida na tela de bloqueio
                .setPriority(NotificationCompat.PRIORITY_HIGH)  //Define a prioridade da notificação em APIs inferiores a 26
                .build();   //Constrói a notificação
        //Emite a notificação que foi construida. O id serve para atualizar a notificação existente sem criar outra notificação
        notificationManager.notify(1, notificacao);
    }

    public void enviarCanal1(View v){
        String titulo = edtTitulo.getText().toString();
        String mensagem = edtMensagem.getText().toString();

        Intent atividadeIntent = new Intent(this, MainActivity.class);
        PendingIntent conteudoIntent = PendingIntent.getActivity(this, 0, atividadeIntent, 0);

        Notification notificacao = new NotificationCompat.Builder(this, CANAL_1_ID)
                .setSmallIcon(R.drawable.ic_um)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setOnlyAlertOnce(true) //Faz com que a notificação só seja disruptiva uma vez
                .setContentIntent(conteudoIntent)   // Faz com que a notificação responda ao toque e abra a MainActivity
                .setAutoCancel(true)    //Quando a notificação for selecionada, será liberada da gaveta de notificações
                .build();

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
                .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentIntent(conteudoIntent)
                .setColor(Color.BLUE)   //Muda a cor da notificação
                .setAutoCancel(true)
                .build();
        notificationManager.notify(2, notificacao);
    }

    public void enviarCanal3(View v){
        String titulo = edtTitulo.getText().toString();
        String mensagem = edtMensagem.getText().toString();

        Intent atividadeIntent = new Intent(this, MainActivity.class);
        PendingIntent conteudoIntent = PendingIntent.getActivity
                (this, 0, atividadeIntent, 0);
        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("mensagemToast", mensagem);
        PendingIntent acaoIntent = PendingIntent.getBroadcast
                (this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap iconeGrande = BitmapFactory.decodeResource(getResources(), R.drawable.ic_mailicon);

        Notification notificacao = new NotificationCompat.Builder(this, CANAL_3_ID)
                .setSmallIcon(R.drawable.ic_tres)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setLargeIcon(iconeGrande)
                .setLargeIcon(iconeGrande)
                .setStyle(new NotificationCompat.BigTextStyle() //Define o estilo de Notificação Expansível
                        .bigText(mensagem)  //Define o texto da notificação expandida
                        .setBigContentTitle("Título expandido") //Define o título da notificação expandida
                        .setSummaryText("O texto expandido é:")) //Define um texto com qualquer conteúdo
                .addAction(R.mipmap.ic_launcher, "Toast", acaoIntent)   //Adiciona um botão de ação
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setOnlyAlertOnce(true)
                .setContentIntent(conteudoIntent)
                .setAutoCancel(true)
                .build();

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
                        .addLine(mensagem)
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

    public void enviarCanal5(View v){
        String titulo = edtTitulo.getText().toString();
        String mensagem = edtMensagem.getText().toString();
        String replyLabel = "Entre sua resposta aqui";

        int randomRequestCode = new Random().nextInt(54325);
        Intent atividadeIntent = new Intent(this, MainActivity.class);
        atividadeIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent conteudoIntent = PendingIntent.getActivity(this, randomRequestCode, atividadeIntent, 0);

        //Inicialização do RemoteInput
        RemoteInput remoteInput = new RemoteInput.Builder(KEY_REPLY)
                .setLabel(replyLabel)
                .build();

        NotificationCompat.Action replyAction = new NotificationCompat.Action.Builder(
                android.R.drawable.sym_action_chat, "Resposta", conteudoIntent)
                .addRemoteInput(remoteInput)
                .setAllowGeneratedReplies(true)
                .build();

        Notification notificacao = new NotificationCompat.Builder(this, CANAL_5_ID)
                .setSmallIcon(R.drawable.ic_cinco)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setContentIntent(conteudoIntent)
                .addAction(replyAction)
                .build();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("notificationId", 1);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );

        notificationManager.notify(5, notificacao);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        tratarResposta(intent);
    }
    private void tratarResposta(Intent intent){
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            CharSequence charSequence = remoteInput.getCharSequence(
                    KEY_REPLY);
            if (charSequence != null) {
                //Coloca a resposta inline no TextView
                String reply = charSequence.toString();
                respostaNoti.setText("Sua resposta é: " + reply);
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.cancel(5);
            }
        }}

}
