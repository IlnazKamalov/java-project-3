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

    public final MapSchema shape(Map<String, BaseSchema> data) {
        addPredicate(predicate -> predicate instanceof Map && formValidation(data, (Map<?, ?>) predicate));
        return this;
    }

    private boolean formValidation(Map<String, BaseSchema> schemas, Map<?, ?> map) {
        for (Map.Entry<String, BaseSchema> entry: schemas.entrySet()) {
            String key = entry.getKey();
            if (map.containsKey(key) && !(entry.getValue().isValid(map.get(key)))) {
                return false;
            }
        }
        return true;
    }
}
