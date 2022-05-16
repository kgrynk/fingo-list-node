public class MyListNode<T> implements ListNode<T>{

	T data;
	ListNode<T> next;

	public MyListNode(){
		data = null;
		next = null;
	}

	public MyListNode(T data){
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

	boolean hasCycle(ListNode<T> node){
		return false;
	}
}
