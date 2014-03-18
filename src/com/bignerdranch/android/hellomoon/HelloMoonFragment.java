package com.bignerdranch.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
	
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mPlayButton;
	private Button mStopButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon, parent);
		
		mPlayButton = (Button)v.findViewById(R.id.play_button);
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (mPlayer.isPlaying()) {
					mPlayer.pause();
					mPlayButton.setText(R.string.play);
				} else {
					mPlayer.play(getActivity());
					mPlayButton.setText(R.string.pause);
				}
			}
		});
		
		mStopButton = (Button)v.findViewById(R.id.stop_button);
		mStopButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mPlayer.stop();
				mPlayButton.setText(R.string.play);
			}
		});
		
		return v;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}
}
