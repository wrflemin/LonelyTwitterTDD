package ca.ualberta.cs.lonelytwitter.test;

import junit.framework.TestCase;
import ca.ualberta.cs.lonelytwitter.Tweet;

public class TweetTest extends TestCase {

	public void testRandom() {
		Tweet a = new Tweet("a");
		Tweet b = null;
		Tweet c = new Tweet("a");
		Tweet d = a;
		
		assertSame("Two objects refer to the same object", a, d);
		assertNotSame("Two objects do not refer to the same object", a, c);
		assertEquals("Equals (with epsilon)", 5, 5.0000000001, 0.0001);
		assertEquals("Equals", 5, 5);
		assertNotNull("Not null", a);
		assertNull("Null", b);
		assertTrue("True", a.equals(c));
		//fail();
	}
	
	public void testEquals() {
		Tweet normal = new Tweet("test");
		Tweet otherNormal = new Tweet("different text");

		assertFalse("different tweets are not equal",
				normal.equals(otherNormal));
	}
}
