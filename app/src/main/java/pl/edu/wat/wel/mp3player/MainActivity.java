package pl.edu.wat.wel.mp3player;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Play button
        Button play = (Button) findViewById(R.id.play);
        play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri path = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.town);
                mediaPlayer = MediaPlayer.create(MainActivity.this, path);
                mediaPlayer.start();
            }
        });

        //Stop button
        Button stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
            }
        });
    }
    //Destroy of mediplayer activity
    @Override
    protected void onDestroy() {
        if (mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
