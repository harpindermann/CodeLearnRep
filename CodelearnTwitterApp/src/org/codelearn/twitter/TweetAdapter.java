package org.codelearn.twitter;

import java.util.ArrayList;
import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TweetAdapter extends ArrayAdapter<Tweet>{

	private LayoutInflater inflater;
	private List<Tweet> tweets = new ArrayList<Tweet>();
    public TweetAdapter(Activity activity, List<Tweet> items){
    	super(activity, R.layout.tweeter_row, items);
    	tweets = items;
    	inflater = activity.getWindow().getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
    	View tweetItemView = inflater.inflate(R.layout.tweeter_row, parent, false);
    	TextView titleView = (TextView)tweetItemView.findViewById(R.id.tweetTitle);
    	TextView bodyView = (TextView)tweetItemView.findViewById(R.id.tweetBody);
    	titleView.setText(tweets.get(position).getTitle().toString());
    	bodyView.setText(tweets.get(position).getBody().toString());
    	return tweetItemView;
    }

}