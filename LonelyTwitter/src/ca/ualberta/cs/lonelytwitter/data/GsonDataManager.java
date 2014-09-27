package ca.ualberta.cs.lonelytwitter.data;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.content.Context;
import android.util.Log;
import ca.ualberta.cs.lonelytwitter.AbstractTweet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonDataManager implements IDataManager {

	private static final String FILENAME = "gsonfile.sav";

	private Gson gson;
	private Context ctx;

	public GsonDataManager(Context ctx) {
		this.ctx = ctx;
		gson = new Gson();
	}

	public ArrayList<AbstractTweet> loadTweets() {
		ArrayList<AbstractTweet> lts = new ArrayList<AbstractTweet>();

		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(
					ctx.openFileInput(FILENAME)));
			String line;
			StringBuffer fileContent = new StringBuffer();

			while ((line = input.readLine()) != null) {
				fileContent.append(line);
			}

			Type collectionType = new TypeToken<Collection<AbstractTweet>>() {}.getType();
			lts = gson.fromJson(fileContent.toString(), collectionType);

		} catch (Exception e) {
			Log.i("LonelyTwitter", "Error loading tweets");
			e.printStackTrace();
		}

		return lts;
	}

	public void saveTweets(List<AbstractTweet> lts) {
		try {
			FileOutputStream fos = ctx.openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			String jsonTweetList = gson.toJson(lts);
			fos.write(jsonTweetList.getBytes());
			fos.close();
			
			Log.i("Persistence", "Saved: " + jsonTweetList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
