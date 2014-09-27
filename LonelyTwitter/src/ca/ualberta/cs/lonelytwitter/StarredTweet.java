package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class StarredTweet extends AbstractTweet {

	private static final long serialVersionUID = 1L;

	public StarredTweet(String tweetBody) {
		super(new Date(), tweetBody);
	}

	@Override
	public String toString() {
		return "\u2605 " + getTweetDate() + " | " + getTweetBody();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof AbstractTweet)) {
			return false;
		}

		AbstractTweet otherTweet = (AbstractTweet) other;
		return getTweetBody().equals(otherTweet.getTweetBody());
	}
}
