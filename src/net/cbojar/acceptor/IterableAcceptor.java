package net.cbojar.acceptor;

import java.util.function.Consumer;

class IterableAcceptor<T> implements Acceptor<T>
{
	private Iterable<T> values;

	public IterableAcceptor(Iterable<T> values) {
		this.values = values;
	}

	public Acceptor<T> accept(Consumer<T> visitor) {
		for(T value : values) {
			new ObjectAcceptor<T>(value).accept(visitor);
		}
		return this;
	}

	public <U extends T> Acceptor<T> accept(Class<U> klass, Consumer<? super U> visitor) {
		for(T value : values) {
			new ObjectAcceptor<T>(value).accept(klass, visitor);
		}
		return this;
	}
}
