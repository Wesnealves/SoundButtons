package com.example.myapllicationesdrasaula1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SoundPool _soundPool;
    private SparseIntArray mSoundMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();
            _soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }else{
            _soundPool = new SoundPool(1,AudioManager.STREAM_MUSIC,0);
        }


        mSoundMap = new SparseIntArray();
        try{
            mSoundMap.put(R.id.button_sound1,_soundPool.load(getApplicationContext(),R.raw.snd_00,1));
            mSoundMap.put(R.id.button_sound2,_soundPool.load(getApplicationContext(),R.raw.snd_01,1));
            mSoundMap.put(R.id.button_sound3,_soundPool.load(getApplicationContext(),R.raw.snd_02,1));
            mSoundMap.put(R.id.button_sound4,_soundPool.load(getApplicationContext(),R.raw.snd_03,1));
            mSoundMap.put(R.id.button_sound5,_soundPool.load(getApplicationContext(),R.raw.snd_04,1));
            mSoundMap.put(R.id.button_sound6,_soundPool.load(getApplicationContext(),R.raw.snd_05,1));
            mSoundMap.put(R.id.button_sound7,_soundPool.load(getApplicationContext(),R.raw.snd_06,1));
            mSoundMap.put(R.id.button_sound8,_soundPool.load(getApplicationContext(),R.raw.snd_07,1));
            mSoundMap.put(R.id.button_sound9,_soundPool.load(getApplicationContext(),R.raw.snd_08,1));
            mSoundMap.put(R.id.button_sound10,_soundPool.load(getApplicationContext(),R.raw.snd_09,1));
            mSoundMap.put(R.id.button_sound11,_soundPool.load(getApplicationContext(),R.raw.snd_010,1));
            mSoundMap.put(R.id.button_sound12,_soundPool.load(getApplicationContext(),R.raw.snd_011,1));
            mSoundMap.put(R.id.button_sound13,_soundPool.load(getApplicationContext(),R.raw.snd_012,1));
            mSoundMap.put(R.id.button_sound14,_soundPool.load(getApplicationContext(),R.raw.snd_013,1));
            mSoundMap.put(R.id.button_sound15,_soundPool.load(getApplicationContext(),R.raw.snd_014,1));
            mSoundMap.put(R.id.button_sound16,_soundPool.load(getApplicationContext(),R.raw.snd_015,1));
            mSoundMap.put(R.id.button_sound17,_soundPool.load(getApplicationContext(),R.raw.snd_0000000,1));

        }catch (Exception e){
            Log.e("MainActivity", "Error: " + e.getLocalizedMessage());
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _soundPool.release();;
        _soundPool = null;
    }
    public void toast(String cor) {
        Toast.makeText(this, "Click do botao: " + cor, Toast.LENGTH_SHORT).show();
    }
    public void playSound(View view) {

        int idSom = mSoundMap.get(view.getId());
        _soundPool.play(idSom, 1.0F, 1.0F, 1, 0, 1.0F);
    }

}
