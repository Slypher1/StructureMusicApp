package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DetailsActivity extends AppCompatActivity {

    public static int songIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(getIntent().getExtras() != null) {
            songIndex = getIntent().getIntExtra(MainActivity.INTENT_KEY_SONG, 0);
        }

        ImageView coverImageView = (ImageView) findViewById(R.id.cover_image_view);
        coverImageView.setImageResource(MainActivity.songs.get(songIndex).getmImageCover());

        EditText songEditText = (EditText) findViewById(R.id.song_edit_text);
        songEditText.setText(MainActivity.songs.get(songIndex).getmSongName());

        EditText artistEditText = (EditText) findViewById(R.id.artist_edit_text);
        artistEditText.setText(MainActivity.songs.get(songIndex).getmArtistName());

        EditText abumEditText = (EditText) findViewById(R.id.album_edit_text);
        abumEditText.setText(MainActivity.songs.get(songIndex).getmAlbumName());

        this.setTitle(MainActivity.songs.get(songIndex).getmSongName() + "-" + MainActivity.songs.get(songIndex).getmArtistName());

        Button playButton = (Button) findViewById(R.id.play_song_button);
        playButton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, NowPlayingActivity.class);
                intent.putExtra(MainActivity.INTENT_KEY_SONG, songIndex);
                startActivity(intent);
            }
        });

        Button saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                //TODO: save the modify to song's properties
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
