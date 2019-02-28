package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String INTENT_KEY_SONG = "SelectSong";
    public static ArrayList<Song> songs = new ArrayList<Song>();
    public static boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //switch to landscape to portrait add 10 elements to arraylist, with this check not happen
        if(firstTime){
            songs.add(new Song(getString(R.string.song1_name), getString(R.string.song1_artist), getString(R.string.song1_album),  R.drawable.matchbox_twenty));
            songs.add(new Song(getString(R.string.song2_name), getString(R.string.song2_artist), getString(R.string.song2_album), R.drawable.a_day_to_remember));
            songs.add(new Song(getString(R.string.song3_name), getString(R.string.song3_artist), getString(R.string.song3_album), R.drawable.green_day));
            songs.add(new Song(getString(R.string.song4_name), getString(R.string.song4_artist), getString(R.string.song4_album), R.drawable.the_script ));
            songs.add(new Song(getString(R.string.song5_name), getString(R.string.song5_artist), getString(R.string.song5_album), R.drawable.kansas ));
            songs.add(new Song(getString(R.string.song6_name), getString(R.string.song6_artist), getString(R.string.song6_album), R.drawable.bastille ));
            songs.add(new Song(getString(R.string.song7_name), getString(R.string.song7_artist), getString(R.string.song7_album), R.drawable.the_darkness));
            songs.add(new Song(getString(R.string.song8_name), getString(R.string.song8_artist), getString(R.string.song8_album), R.drawable.onerepublic));
            songs.add(new Song(getString(R.string.song9_name), getString(R.string.song9_artist), getString(R.string.song9_album), R.drawable.alestorm));
            songs.add(new Song(getString(R.string.song10_name), getString(R.string.song10_artist), getString(R.string.song10_album), R.drawable.muse));
            firstTime = false;

            Toast.makeText(this, getString(R.string.instruction), Toast.LENGTH_LONG).show();
        }

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list_item);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent songsIntent = new Intent(MainActivity.this, DetailsActivity.class);
                songsIntent.putExtra(INTENT_KEY_SONG, i);
                startActivity(songsIntent);
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent songsIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                songsIntent.putExtra(INTENT_KEY_SONG, i);
                startActivity(songsIntent);
            }
        });
    }
}
