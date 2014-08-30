package org.codelearn.twitter;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TweetDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras =getIntent().getExtras();
		String body = extras.getString("Body");
		String title = extras.getString("Title");
		//Log.d("IntentDataReceived",title);
		setContentView(R.layout.activity_tweet_detail);
		TextView bodyView = (TextView)(findViewById(R.id.tweetBody));
		TextView titleView = (TextView)findViewById(R.id.tweetTitle);
		bodyView.setText(body);
		titleView.setText(title);
	}

	

}
