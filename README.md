# Acceptor (in Java)

This is a generic, universal implementation of the Visitor Pattern. It can
extend the visitor pattern to any object or collection of objects. Internally,
it checks the type of the wrapped object against the desired type, and calls the
visitor if the internal object can be cast to the desired type.

This library requires Java 8.

## Usage

To get an `Acceptor`, use the `Acceptors` static factory class. For `Acceptor`s
for single objects, use `Acceptors.fromObject` and pass in the object. For
multiple objects in an `Iterable`, use `Acceptor.fromIterable` and pass in the
`Iterable`. Both of these methods return an `Acceptor<T>` object, where `T` is
the type of the objects to visit.

To visit the object(s) in an `Acceptor`, call the `Acceptor#accept` method with
two parameters: a `Class<U>` object where `U` is the type of object you want to
visit, and a `Consumer<? super U>` that is the behavior you want called on the
object(s) to visit. The input parameter to the `Consumer` will be the object to
visit, cast to `U`.

The `Acceptor` API is fluent, meaning `Acceptor#accept` returns another
`Acceptor`, usually the same acceptor, so that `#accept` can be called again in
chain.

Here is an example of how to use a single-object `Acceptor`:

```java
import java.util.*;
import net.cbojar.acceptor.*;

class Main
{
    public static void main(String args[]) {
        Acceptor<String> acceptor = Acceptors.fromObject("String");
        acceptor.accept(String.class, string -> {
            System.out.printf("It's a string! Size: %d Value: %s\n", string.length(), string.toString());
        });
    }
}
```

Here is an example of how to use an iterable Acceptor:

```java
import java.util.*;
import net.cbojar.acceptor.*;

class Main
{
    public static void main(String args[]) {
        Acceptor<Object> acceptor = Acceptors.fromIterable(Arrays.asList("String1", "String2", 1));
        acceptor.accept(String.class, (CharSequence string) -> {
            System.out.printf("It's a CharSequence! Size: %d Value: %s\n", string.length(), string.toString());
        }).accept(Integer.class, i -> {
            System.out.printf("It's a number! Value: %d\n", i);
        });
    }
}
```
