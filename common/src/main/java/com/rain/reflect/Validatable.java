package com.rain.reflect;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validatable {
}
