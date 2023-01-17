package net.tradingDiary.tradingdiarybackend.payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class OperationNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(OperationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String operationNotFoundHandler(OperationNotFoundException ex) {
        return ex.getMessage();
    }
}
