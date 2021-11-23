package vn.tat.crud.tidb.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import vn.tat.crud.tidb.enumeration.MessageCodeEnum;
import vn.tat.crud.tidb.exception.NABException;

import javax.validation.ConstraintViolation;

public class ProductValidator {

    public static void validate(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            handleError(bindingResult.getAllErrors().get(0));
        }
    }

    private static void handleError(ObjectError error) {
        ConstraintViolation violation = error.unwrap(ConstraintViolation.class);
        String defaultMessage = violation.getMessage();
        if (StringUtils.isEmpty(defaultMessage)) {
            throw new NABException(
                    MessageCodeEnum.COMMON_ERROR_017,
                    HttpStatus.BAD_REQUEST,
                    violation.getPropertyPath(),
                    violation.getInvalidValue()
            );
        } else {
            throw new NABException(
                    MessageCodeEnum.COMMON_ERROR_018,
                    HttpStatus.BAD_REQUEST,
                    violation.getPropertyPath(),
                    violation.getInvalidValue()
            );
        }
    }
}
