package ca.ualberta.cs.lonelytwitter.test;

import junit.framework.TestCase;
import ca.ualberta.cs.lonelytwitter.AbstractTweet;
import ca.ualberta.cs.lonelytwitter.Tweet;
import ca.ualberta.cs.lonelytwitter.data.TweetListModel;

public class TweetListModelTest extends TestCase {

	TweetListModel listModel;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		listModel = new TweetListModel();
	}

	public void testSuccessfulAddTweet() {
		listModel.addTweet(new Tweet("First"));
		assertEquals("List returns 1 count after add", 1, listModel.getCount());

		listModel.addTweet(new Tweet("Second"));
		assertEquals("List returns 2 count after add", 2, listModel.getCount());
	}

	public void testRepeatedAddTweet() {
		try {
			listModel.addTweet(new Tweet("First"));
			listModel.addTweet(new Tweet("Second"));
			listModel.addTweet(new Tweet("Third"));
			listModel.addTweet(new Tweet("Second"));
			fail("Missing repeated addTweet exception");
		} catch (IllegalArgumentException e) {
			assertEquals("Expected exception when adding repeated tweet",
					"Duplicate tweet error", e.getMessage());
		}
	}

	public void testGetCount() {
		assertEquals("Empty list returns 0 count", 0, listModel.getCount());

		listModel.addTweet(new Tweet("First"));
		assertEquals("List returns 1 count after add", 1, listModel.getCount());

		listModel.addTweet(new Tweet("Second"));
		assertEquals("List returns 2 count after add", 2, listModel.getCount());

		listModel.removeTweet(new Tweet("First"));
		assertEquals("List return 1 count after remove", 1,
				listModel.getCount());

		listModel.removeTweet(new Tweet("Second"));
		assertEquals("List return 0 count after remove", 0,
				listModel.getCount());
	}

	public void testHasTweet() {
		AbstractTweet tweet1 = new Tweet("First");
		assertFalse("Does not have tweet when list is empty",
				listModel.hasTweet(tweet1));
		listModel.addTweet(tweet1);

		AbstractTweet tweet2 = new Tweet("Second");
		assertFalse("Tweet2 is not in the list yet", listModel.hasTweet(tweet2));
		listModel.addTweet(tweet2);

		assertTrue("Has tweet using the same reference as tweet1",
				listModel.hasTweet(tweet1));

		AbstractTweet tweet3 = new Tweet("Second");
		assertTrue(
				"Has tweet using the different reference but same text as tweet2",
				listModel.hasTweet(tweet3));
	}

	public void testRemoveTweet() {
		listModel.removeTweet(new Tweet("X"));
		assertEquals(
				"Empty list returns 0 count after remove unexistent tweet", 0,
				listModel.getCount());

		listModel.addTweet(new Tweet("First"));
		listModel.addTweet(new Tweet("Second"));
		assertEquals("List returns 2 count after 2 adds", 2,
				listModel.getCount());

		listModel.removeTweet(new Tweet("First"));
		assertEquals("List returns 1 count after remove", 1,
				listModel.getCount());

		listModel.removeTweet(new Tweet("Third"));
		assertEquals("List returns 1 count after removing unexistent tweet", 1,
				listModel.getCount());

		listModel.removeTweet(new Tweet("Second"));
		assertEquals("List returns 0 count after remove", 0,
				listModel.getCount());
	}

	public void testGetTweets() {
		assertEquals("Get tweets return 0 tweets when empty", 0,
				listModel.getTweets().length);

		listModel.addTweet(new Tweet("First"));
		listModel.addTweet(new Tweet("Second"));
		listModel.addTweet(new Tweet("Third"));

		AbstractTweet[] arrayOfTweets = listModel.getTweets();

		assertEquals("Get list return tweet in order 1", "First",
				arrayOfTweets[0].getTweetBody());
		assertEquals("Get list return tweet in order 2", "Second",
				arrayOfTweets[1].getTweetBody());
		assertEquals("Get list return tweet in order 3", "Third",
				arrayOfTweets[2].getTweetBody());
	}

}
