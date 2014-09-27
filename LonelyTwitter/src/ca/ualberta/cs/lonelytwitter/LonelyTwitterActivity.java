package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import ca.ualberta.cs.lonelytwitter.data.FileDataManager;
import ca.ualberta.cs.lonelytwitter.data.IDataManager;
import ca.ualberta.cs.lonelytwitter.data.TweetListModel;

public class LonelyTwitterActivity extends Activity {

	private EditText bodyText;
	private ListView oldTweetsList;

	private TweetListModel tweetListModel;
	private ArrayAdapter<AbstractTweet> adapter;
	private IDataManager tweetsProvider;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
	}

	@Override
	protected void onStart() {
		super.onStart();

		tweetsProvider = new FileDataManager(this);
		tweetListModel = new TweetListModel(tweetsProvider.loadTweets());
		adapter = new ArrayAdapter<AbstractTweet>(this, R.layout.list_item,
				tweetListModel.getList());
		oldTweetsList.setAdapter(adapter);
	}

	public void save(View v) {
		String text = bodyText.getText().toString();
		AbstractTweet tweet;

		// starred tweet if contains *
		if (text.contains("*")) {
			tweet = new StarredTweet(text);
		} else {
			tweet = new Tweet(text);
		}

		tweetListModel.addTweet(tweet);
		adapter.notifyDataSetChanged();

		bodyText.setText("");
		tweetsProvider.saveTweets(tweetListModel.getList());
	}

	public void clear(View v) {
		tweetListModel.clear();
		adapter.notifyDataSetChanged();
		tweetsProvider.saveTweets(tweetListModel.getList());
	}
}