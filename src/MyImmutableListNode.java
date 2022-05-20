import java.util.*;

public final class MyImmutableListNode<T> implements ImmutableListNode<T> {
	private T data;
	private ImmutableListNode<T> next;

	public MyImmutableListNode(ListNode<T> node) {

		Stack<ListNode<T>> visited = new Stack<>();
		ListNode<T> head = node;
		boolean cycle = false;

		while (head != null) {
			if (visited.contains(head)) {
				cycle = true;
				break;
			}
			visited.push(head);
			head = head.next();
		}

		MyImmutableListNode<T> immutableNode = null;
		MyImmutableListNode<T> prev = null;
		MyImmutableListNode<T> lastNode = null;
		boolean last = true;

		while (visited.size() > 1) {
			ListNode<T> tail = visited.pop();
			immutableNode = new MyImmutableListNode<T>(tail.data(), prev);

			if (cycle) {
				if (last) {
					last = false;
					lastNode = immutableNode;
				}
				if (head == tail) {
					lastNode.next = immutableNode;
				}
			}
			prev = immutableNode;
		}

		this.data = visited.pop().data();
		this.next = immutableNode;
	}

	private MyImmutableListNode(T data, ImmutableListNode<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public T data() {
		return data;
	}

	@Override
	public ImmutableListNode<T> next() {
		return next;
	}

	@Override
	public boolean isEmpty() {
		return data == null && next == null;
	}

	boolean hasCycle(ImmutableListNode<T> node) {
		ImmutableListNode<T> tortoise = node;
		ImmutableListNode<T> hare = node;

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
