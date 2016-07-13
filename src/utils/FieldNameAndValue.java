package utils;

/**
 * Created by socha on 2016-06-28.
 */
public class FieldNameAndValue {
    String fieldName;
    double value;

    public FieldNameAndValue(String fieldName, double value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public double getValue() {
        return value;
    }
}
