
@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ValidationException ex){
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex){
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}