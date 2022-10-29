package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {


    public final NumberSchema required() {
        addPredicate(predicate -> predicate instanceof Integer && !String.valueOf(predicate).isEmpty());
        return this;
    }

    public final NumberSchema positive() {
        addPredicate(predicate -> predicate instanceof Integer && ((Integer) predicate) > 0);
        return this;
    }

    public final NumberSchema range(int start, int end) {
        addPredicate(predicate -> predicate instanceof Integer
                &&
                (Integer) predicate >= start && (Integer) predicate <= end);
        return this;
    }
}
