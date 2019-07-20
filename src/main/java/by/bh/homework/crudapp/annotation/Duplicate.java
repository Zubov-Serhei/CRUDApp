package by.bh.homework.crudapp.annotation;

import by.bh.homework.crudapp.validation.FieldUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldUniqueValidator.class)   //Этой аннотацией указывается, какой класс будет проверять на правильность данные.
@Documented
public @interface Duplicate {
    public static final String MESSAGE = "fields.notMatches";

    String message() default MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        Duplicate[] value();
    }

}