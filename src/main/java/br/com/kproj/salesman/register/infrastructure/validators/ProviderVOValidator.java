package br.com.kproj.salesman.register.infrastructure.validators;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.kproj.salesman.register.view.dto.ProviderDTO;


@Component
public class ProviderVOValidator implements Validator {

    private static final String COMPANY = "company";
    private static final String INDIVIDUAL = "individual";


    private Map<String, Validator> validators = new HashMap<>();

    @Autowired
    public ProviderVOValidator(CompanyValidator companyValidator, IndividualValidator individualValidator) {
        validators.put(COMPANY, companyValidator);
        validators.put(INDIVIDUAL, individualValidator);
    }


    @Override
    public boolean supports(Class<?> paramClass) {
        return ProviderDTO.class.equals(paramClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ProviderDTO providerDTO = (ProviderDTO) target;
        Validator validator = validators.get(providerDTO.getType());

        ValidationUtils.invokeValidator(validator, providerDTO.getProvider(), errors);

    }
}