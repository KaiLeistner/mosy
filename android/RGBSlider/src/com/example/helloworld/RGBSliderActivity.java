package com.example.helloworld;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class RGBSliderActivity extends Activity{
    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get Seekbar objects
        seekBarRed = (SeekBar) findViewById(R.id.seekBarRed);
    	seekBarGreen = (SeekBar) findViewById(R.id.seekBarGreen);
    	seekBarBlue = (SeekBar) findViewById(R.id.seekBarBlue);
        
    	// define and Listener (anonymous inner class)
        OnSeekBarChangeListener seekbarListener = new OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				setBackgroundColor();
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
        };
        
    	seekBarRed.setOnSeekBarChangeListener(seekbarListener);
    	seekBarGreen.setOnSeekBarChangeListener(seekbarListener);
    	seekBarBlue.setOnSeekBarChangeListener(seekbarListener);
    	setBackgroundColor();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
       return true;
    }
    
	private void setBackgroundColor() {
		int r = seekBarRed.getProgress() * 255 / 100;
		int g = seekBarGreen.getProgress() * 255 / 100;
		int b = seekBarBlue.getProgress() * 255 / 100;
		this.getWindow().getDecorView().getRootView().setBackgroundColor(Color.argb(255, r, g, b));
	}
}
