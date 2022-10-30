package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private final List<Predicate<Object>> validList = new ArrayList<>();

    public final void addPredicate(Predicate<Object> predicate) {
        validList.add(predicate);
    }

    public final boolean isValid(Object object) {
        for (Predicate<Object> objectPredicate: validList) {
            if (!objectPredicate.test(object)) {
                return false;
            }
        }
        return true;
    }
}
