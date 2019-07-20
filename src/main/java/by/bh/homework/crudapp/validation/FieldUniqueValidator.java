package by.bh.homework.crudapp.validation;

import by.bh.homework.crudapp.annotation.Duplicate;
import by.bh.homework.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldUniqueValidator implements ConstraintValidator<Duplicate, String> {
    private String message = Duplicate.MESSAGE;

    @Autowired
    UserService userService;

    public void initialize(Duplicate constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    public boolean isValid(String mail, ConstraintValidatorContext context) {
        try {
            boolean matches=(0 == userService.checkUserMailExists(mail).size() );
            if (!matches){
                String msg=this.message;
                if( this.message==null || "".equals(this.message) || Duplicate.MESSAGE.equals( this.message ) ){
                    msg="oops. This field already exists.";
                }

                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
            }

            return matches;
        }

        catch (final Exception e) {
            e.printStackTrace();
        }

        return true;
    }

}