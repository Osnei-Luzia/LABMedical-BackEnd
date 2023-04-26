package projeto.labmedicalbackend.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import projeto.labmedicalbackend.controllers.dtos.ErrorRequestSide;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public static ResponseEntity<List<ErrorRequestSide>> error400(MethodArgumentNotValidException e) {
        List<FieldError> erros = e.getFieldErrors();
        return ResponseEntity.badRequest().body(
                erros.stream().map(erro -> new ErrorRequestSide(erro)).collect(Collectors.toList()));
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public static ResponseEntity<String> errorEntitySide(ConstraintViolationException e){
        String erros = e.getConstraintViolations().toString();
        //manipular Set para string
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(DataExistsException.class)
    public static ResponseEntity error404(DataExistsException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
    @ExceptionHandler(CpfExistsException.class)
    public static ResponseEntity error409(CpfExistsException e){
        return ResponseEntity.status(409).body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public static ResponseEntity errorEnum(HttpMessageNotReadableException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(EnumNullPointerException.class)
    public static ResponseEntity errorEnum(EnumNullPointerException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
