public class MyListNode<T> implements ListNode<T> {

	T data;
	ListNode<T> next;

	public MyListNode() {
		data = null;
		next = null;
	}

	public MyListNode(T data) {
		this.data = data;
		next = null;
	}

	@Override
	public T data() {
		return data;
	}

	@Override
	public ListNode<T> next() {
		return next;
	}

	@Override
	public ListNode<T> setNext(ListNode<T> next) {
		this.next = next;
		return this;
	}

	@Override
	public boolean isEmpty() {
		return data == null && next == null;
	}

	boolean hasCycle(ListNode<T> node) {
		ListNode<T> tortoise = node;
		ListNode<T> hare = node;

		do {
			if (tortoise.next() == null)
				return false;
			tortoise = tortoise.next();

			if (hare.next() == null || hare.next().next() == null)
				return false;
			hare = hare.next().next();
		} while (tortoise != hare);

		return true;
	}
}
