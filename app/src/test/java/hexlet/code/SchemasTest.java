package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchemasTest {

    @Test
    void testStringSchema() {
        final Validator v = new Validator();
        final StringSchema schema = v.string();
        final int length = 5;
        final String testString = "what does the fox say";

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();
        schema.minLength(length);
        assertTrue(schema.isValid(testString));
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));

        schema.contains("what");
        assertTrue(schema.isValid(testString));

        schema.contains("whatthe");
        assertFalse(schema.isValid(testString));

        assertFalse(schema.isValid(testString));
    }

    @Test
    public void testNumberSchema() {
        final Validator validator = new Validator();
        final NumberSchema schema = validator.number();
        final int five = 5;
        final int ten = 10;

        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(ten));
        assertFalse(schema.isValid("5"));

        schema.positive();
        assertTrue(schema.isValid(ten));
        assertFalse(schema.isValid(-ten));

        schema.range(five, ten);
        assertTrue(schema.isValid(five));
        assertTrue(schema.isValid(ten));
        assertFalse(schema.isValid(five - 1));
        assertFalse(schema.isValid(ten + 1));
    }

    @Test
    public void testMapSchema() {
        final Validator validator = new Validator();
        final MapSchema schema = validator.map();
        final Map<String, String> data = new HashMap<>();

        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void testNestedValidation() {
        final Validator validator = new Validator();
        final MapSchema schema = validator.map();
        final int positiveInt = 100;
        final int negativeInt = -5;

        Map<String, BaseSchema> data = new HashMap<>();
        data.put("name", validator.string().required());
        data.put("age", validator.number().positive());
        schema.shape(data);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", positiveInt);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", negativeInt);
        assertFalse(schema.isValid(human4));
    }
}
