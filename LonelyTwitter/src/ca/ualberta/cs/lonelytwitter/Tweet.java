package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Tweet extends AbstractTweet {

	private static final long serialVersionUID = 1L;

	public Tweet(String tweetBody) {
		super(new Date(), tweetBody);
	}

	@Override
	public String toString() {
		return getTweetDate() + " | " + getTweetBody();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof AbstractTweet)) {
			return false;
		}

		AbstractTweet otherTweet = (AbstractTweet) other;
		//return true;
		return getTweetBody().equals(otherTweet.getTweetBody());
	}
}
