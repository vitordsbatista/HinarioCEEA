package br.com.batista.hinarioceea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Bundle extras = getIntent().getExtras();
        String lyric = extras.getString("lyric");
        String name = extras.getString("name");

        TextView nameText = (TextView) findViewById(R.id.nameText);
        TextView lyricText = (TextView) findViewById(R.id.lyricText);

        nameText.setText(name);
        lyricText.setText(lyric);
    }
}
//testestesteste