package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        addPredicate(predicate -> predicate instanceof Map);
        return this;
    }

    public final MapSchema sizeof(int size) {
        addPredicate(predicate -> predicate instanceof Map && ((Map<?, ?>) predicate).size() == size);
        return this;
    }
}
