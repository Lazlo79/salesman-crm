package br.com.kproj.salesman.assistants.activities.infrastructure;

import br.com.kproj.salesman.infrastructure.entity.activities.ActivityChecklist;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class ActivityChecklistValidator implements Validator, InitializingBean {

    private javax.validation.Validator validator;



    @Override
    public boolean supports(Class<?> clazz) {
        return ActivityChecklist.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ActivityChecklist checklist = (ActivityChecklist) target;
        Set<ConstraintViolation<Object>> constraints = validator.validate(checklist);

        constraints.forEach(error ->
                errors.rejectValue(error.getPropertyPath().toString(), error.getMessage()));

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            this.validator = factory.getValidator();
        } catch(Exception e) {}
    }
}