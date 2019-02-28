package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    public static int songIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras() != null){
            songIndex = getIntent().getIntExtra(MainActivity.INTENT_KEY_SONG, 0);
        }

        Song songPlaying = MainActivity.songs.get(songIndex);

        ImageView coverImage = (ImageView)findViewById(R.id.cover_now_playing);
        coverImage.setImageResource(songPlaying.getmImageCover());
        this.setTitle(songPlaying.getmSongName() + " - " + songPlaying.getmArtistName());

        Button propertiesButton = (Button) findViewById(R.id.song_properties_button);
        propertiesButton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NowPlayingActivity.this, DetailsActivity.class);
                intent.putExtra(MainActivity.INTENT_KEY_SONG, songIndex);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
