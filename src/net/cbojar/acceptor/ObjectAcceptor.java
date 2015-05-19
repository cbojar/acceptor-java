package net.cbojar.acceptor;

import java.util.function.Consumer;

class ObjectAcceptor<T> implements Acceptor<T>
{
	private T value;

	public ObjectAcceptor(T value) {
		this.value = value;
	}

	public Acceptor<T> accept(Consumer<T> visitor) {
		visitor.accept(value);
		return this;
	}

	public <U extends T> Acceptor<T> accept(Class<U> klass, Consumer<? super U> visitor) {
		if(isMyType(klass)) {
			visitor.accept(klass.cast(value));
		}
		return this;
	}

	private <U extends T> boolean isMyType(Class<U> klass) {
		return klass.isAssignableFrom(value.getClass());
	}
}
