package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private final List<Predicate<Object>> checks = new ArrayList<>();

    public final void addPredicate(Predicate<Object> predicate) {
        checks.add(predicate);
    }

    public final boolean isValid(Object object) {
        for (Predicate<Object> objectPredicate: checks) {
            if (!objectPredicate.test(object)) {
                return false;
            }
        }
        return true;
    }
}
