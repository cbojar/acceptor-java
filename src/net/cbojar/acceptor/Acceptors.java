package net.cbojar.acceptor;

public final class Acceptors
{
	public static <T> Acceptor<T> fromObject(T object) {
		return new ObjectAcceptor<T>(object);
	}

	public static <T> Acceptor<T> fromIterable(Iterable<T> iterable) {
		return new IterableAcceptor<T>(iterable);
	}

	private Acceptors() {};
}
