package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        addPredicate(predicate -> predicate instanceof String && !String.valueOf(predicate).isEmpty());
        return this;
    }

    public final StringSchema minLength(int length) {
        addPredicate(value -> value instanceof String && String.valueOf(value).length() >= length);
        return this;
    }

    public final StringSchema contains(String string) {
        addPredicate(predicate -> predicate instanceof String && String.valueOf(predicate).contains(string));
        return this;
    }
}
