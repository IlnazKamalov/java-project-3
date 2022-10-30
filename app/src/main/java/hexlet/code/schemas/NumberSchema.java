package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {


    public final NumberSchema required() {
        addPredicate(predicate -> predicate instanceof Integer);
        return this;
    }

    public final NumberSchema positive() {
        addPredicate(predicate -> predicate == null// data.put("age", validator.number().positive()); - true
                || predicate instanceof Integer && (Integer) predicate > 0);
        return this;
    }

    public final NumberSchema range(int start, int end) {
        addPredicate(predicate -> predicate instanceof Integer
                && (Integer) predicate >= start && (Integer) predicate <= end);
        return this;
    }
}
