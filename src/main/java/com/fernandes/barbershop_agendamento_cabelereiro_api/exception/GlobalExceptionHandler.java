package com.fernandes.barbershop_agendamento_cabelereiro_api.exception;

import com.fernandes.barbershop_agendamento_cabelereiro_api.exception.PlanoException.PlanoNotFoundException;
import com.fernandes.barbershop_agendamento_cabelereiro_api.exception.pessoaException.PessoaNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Captura erros de validação do corpo (@RequestBody)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // (Opcional) Captura erros de validação de parâmetros de URL ou query params
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolation(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<StartHandleException> pessoaNotFount(PessoaNotFoundException e) {
        StartHandleException error = new StartHandleException(e.getMessage(), HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(PlanoNotFoundException.class)
    public ResponseEntity<StartHandleException> pessoaNotFount(PlanoNotFoundException e) {
        StartHandleException error = new StartHandleException(e.getMessage(), HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
