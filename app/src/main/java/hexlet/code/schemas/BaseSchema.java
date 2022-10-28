package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private final List<Predicate<Object>> validList = new ArrayList<>();

    protected void addPredicate(Predicate<Object> predicate) {
        validList.add(predicate);
    }

    public boolean isValid(Object o) {
        for (Predicate<Object> objectPredicate: validList) {
            if(!objectPredicate.test(o)) {
                return false;
            }
        }
        return true;
    }
}
