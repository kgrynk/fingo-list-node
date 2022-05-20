public interface ImmutableListNode<T> {
	T data();
	ImmutableListNode<T> next();
	boolean isEmpty();

}
