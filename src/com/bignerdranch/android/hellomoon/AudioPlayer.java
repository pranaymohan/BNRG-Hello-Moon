package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
	
	private MediaPlayer mPlayer;
	
	public void initialize(Context c) {
		//Initial call to stop, to make sure only one instance exists if the user clicks play twice
		stop();
		
		mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				stop();
			}
		});
	}
	
	public void stop() {
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}
	
	public void play(Context c) {
		if (mPlayer == null) {
			initialize(c);
		}
		mPlayer.start();
	}
	
	public void pause() {
		mPlayer.pause();
	}
	
	public boolean isPlaying() {
		if (mPlayer == null) return false;
		if (mPlayer.isPlaying()) return true;
		else return false;
	}

}
