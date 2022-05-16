import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

	@Test
	void dataTest() {
		MyListNode<Integer> list = new MyListNode<>(42);
		assertEquals(42, list.data());
	}

	@Test
	void nextTest() {
		final MyListNode<Integer> list = new MyListNode<>();
		final MyListNode<Integer> list2 = new MyListNode<>();

		assertNull(list.next());
		list.setNext(list2);
		assertEquals(list2, list.next());
	}

	@Test
	void emptyTest() {
		final MyListNode<Integer> list = new MyListNode<>();
		final MyListNode<Integer> list2 = new MyListNode<>(42);

		assertTrue(list.isEmpty());
		assertFalse(list2.isEmpty());
	}

}
