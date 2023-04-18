package projeto.labmedicalbackend.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
public class UsuarioHttpErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public static ResponseEntity<List<FieldError>> error400(MethodArgumentNotValidException e){
        List<FieldError> erros = e.getFieldErrors();
        //mapear lista de erros
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public static ResponseEntity error409(IllegalArgumentException e){
        //listar por propriedade de argument quais respostas mandar
    return ResponseEntity.badRequest().body(e.getMessage());
    }
}
