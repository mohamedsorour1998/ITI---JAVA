
//A predicate that accepts two arguments and returns a boolean.
@FunctionalInterface
public interface BiPredicate<T, U> {
    // Evaluates this predicate on the given arguments.
    boolean test(T t, U u);
}