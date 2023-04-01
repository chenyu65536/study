package com.rain.reflect;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by chenyu on 2018/1/1.
 */

@Target({METHOD, PARAMETER, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BeanValidator.class)
public @interface BeanValid {
    String message() default "{value}不能为空";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @interface List {
        BeanValid[] value();
    }
}
