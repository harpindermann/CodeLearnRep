package org.codelearn.twitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class TweetListActivity extends ListActivity {
	private static final String TWEETS_CACHE_FILE = "tweet_cache.ser";
	private String[] stringArray;
	private TweetAdapter tweetItemArrayAdapter;
	private List<Tweet> tweets = new ArrayList<Tweet>();
	private List<Tweet> tweetsWrite = new ArrayList<Tweet>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweet_list);
		for(int i=0;i<20;i++)
		{
			Tweet tweet = new Tweet();
			tweet.setBody("Body of tweet# "+(i+1));
			tweet.setTitle("Title of tweet# "+(i+1));
			tweetsWrite.add(tweet);
		}
		try
		{
			FileInputStream fis = openFileInput(TWEETS_CACHE_FILE);
			ObjectInputStream ois = new ObjectInputStream(fis);
			tweets = (List<Tweet>)ois.readObject();
			ois.close();
			fis.close();
			FileOutputStream fos = openFileOutput(TWEETS_CACHE_FILE,MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(tweetsWrite);
			oos.close();
			fos.close();
		}
		catch(FileNotFoundException e)
		{
			Log.d("CodeLearn","Tweet Cache File not found");
		}
		catch(IOException e)
		{
			Log.d("CodeLearn","An exception has occurred in TweetListActivity"+e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			Log.d("CodeLearn","An exception has occurred in TweetListActivity");
		}
		tweetItemArrayAdapter = new TweetAdapter(this, tweets);
		setListAdapter(tweetItemArrayAdapter);

	}

	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(TweetListActivity.this,TweetDetailActivity.class);
		String body = ((TextView)(v.findViewById(R.id.tweetBody))).getText().toString();
		String title = ((TextView)(v.findViewById(R.id.tweetTitle))).getText().toString();
		intent.putExtra("Body", body);
		intent.putExtra("Title", title);
		startActivity(intent);
	}
}
