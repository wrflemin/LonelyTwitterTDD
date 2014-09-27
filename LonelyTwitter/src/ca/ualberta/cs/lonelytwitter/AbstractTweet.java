package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractTweet implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date tweetDate;
	private String tweetBody;

	public AbstractTweet(Date tweetDate, String tweetBody) {
		super();
		this.tweetDate = tweetDate;
		this.tweetBody = tweetBody;
	}

	public Date getTweetDate() {
		return tweetDate;
	}

	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	public abstract boolean equals(Object other);

	public abstract String toString();
}
