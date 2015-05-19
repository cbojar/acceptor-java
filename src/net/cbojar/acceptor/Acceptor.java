package net.cbojar.acceptor;

import java.util.function.Consumer;

public interface Acceptor<T>
{
	public Acceptor<T> accept(Consumer<T> visitor);
	public <U extends T> Acceptor<T> accept(Class<U> klass, Consumer<? super U> visitor);
}
