package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.Tweet;
import ca.ualberta.cs.lonelytwitter.data.TweetListModel;
import android.test.ActivityInstrumentationTestCase2;


public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{
	public TweetListModelTest(){
		super(LonelyTwitterActivity.class);
	}

	public void testAddTweet(){
		Tweet t1 = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello");
		int tweetsInList1;
		int tweetsInList2;
		TweetListModel mTweetListModel = new TweetListModel();
		
		mTweetListModel.addTweet(t1);
		tweetsInList1 = mTweetListModel.getCount();
		try{
			mTweetListModel.addTweet(t2);
		}
		catch (IllegalArgumentException iAE){
			
		}
		tweetsInList2 = mTweetListModel.getCount();
		
		assertEquals("Lists are the same",tweetsInList1,tweetsInList2);
		
	}
	
	public void testCount(){
		Tweet t1 = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello Again");
		int tweetCount1;
		int tweetCount2;
		
		TweetListModel mTLM = new TweetListModel();
		
		mTLM.addTweet(t1);
		tweetCount1 = mTLM.getCount();
		assertEquals("List is length 1",1,tweetCount1);
		mTLM.addTweet(t2);
		tweetCount2 = mTLM.getCount();
		assertEquals("List is length 2",2,tweetCount2);
		
	}
	
	public void testHasTweet(){
		Tweet t1 = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello");
		boolean hasTweet;
		
		TweetListModel mTweetListModel = new TweetListModel();
		
		mTweetListModel.addTweet(t1);
		hasTweet = mTweetListModel.hasTweet(t2);
		
		
		assertEquals("Has Tweet",true,hasTweet);
		
	}
	
	public void testRemoveTweet(){
		Tweet t1 = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello Again");
		
		TweetListModel mTweetListModel = new TweetListModel();
		
		mTweetListModel.addTweet(t1);
		mTweetListModel.addTweet(t2);
		
		mTweetListModel.removeTweet(t2);
		
		assertEquals("Tweet Removed",1,mTweetListModel.getCount());
	}
	public void testGetTweets(){
		AbstractTweet t1 = new Tweet("Hello");
		AbstractTweet t2 = new Tweet("Hello Again");
		AbstractTweet[] tweetList = new AbstractTweet[2];
		
		tweetList[0] = t1;
		tweetList[1] = t2;
		
		
		TweetListModel mTweetListModel = new TweetListModel();
		
		mTweetListModel.addTweet(t1);
		mTweetListModel.addTweet(t2);
		
		assertEquals("List in order",tweetList,mTweetListModel.getTweets());
		
		
	}
}
