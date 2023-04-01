package com.rain.reflect;

/**
 * Created by chenyu on 2018/1/1.
 */

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Created by chenyu on 2018/1/1.
 */
public class BeanValidator implements ConstraintValidator<BeanValid, Object> {

    private BeanValid beanValid;

    public void initialize(BeanValid beanValid) {
        this.beanValid = beanValid;
    }

    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object == null) {
            return false;
        }

        Object value;
        try {
            value = new PropertyDescriptor(beanValid.value(), object.getClass()).getReadMethod().invoke(object);
        } catch (Exception e) {
            value = null;
        }

        if (value == null) {
            return false;
        }
        if (value instanceof Number) {
            return true;
        }
        if (value instanceof String) {
            return ((String) value).trim().length() > 0;
        } else if (value instanceof CharSequence) {
            return ((CharSequence) value).length() > 0;
        } else if (value instanceof Collection) {
            return ((Collection) value).size() > 0;
        } else if (value instanceof Map) {
            return ((Map) value).size() > 0;
        } else if (value.getClass().isArray()) {
            return Array.getLength(value) > 0;
        } else if (value.getClass().isEnum()){
            return true;
        }
        return false;
    }
}

