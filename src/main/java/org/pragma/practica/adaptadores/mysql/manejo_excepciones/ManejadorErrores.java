package org.pragma.practica.adaptadores.mysql.manejo_excepciones;

import org.pragma.practica.dominio.excepciones.BadRequestException;
import org.pragma.practica.dominio.excepciones.ConflictException;
import org.pragma.practica.dominio.excepciones.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

    @ControllerAdvice
    public class ManejadorErrores {

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler({ NotFoundException.class })
        @ResponseBody
        public ErrorMessage notFoundRequest(Exception exception) {
            return new ErrorMessage(exception);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler({ BadRequestException.class, org.springframework.dao.DuplicateKeyException.class,
                org.springframework.web.bind.MethodArgumentNotValidException.class,
                org.springframework.http.converter.HttpMessageNotReadableException.class,
                org.springframework.web.HttpRequestMethodNotSupportedException.class })

        @ResponseBody
        public ErrorMessage badRequest(Exception exception) {
            return new ErrorMessage(exception);
        }

        @ResponseStatus(HttpStatus.CONFLICT)
        @ExceptionHandler({ ConflictException.class })
        @ResponseBody
        public ErrorMessage conflict(Exception exception) {
            return new ErrorMessage(exception);
        }

        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ExceptionHandler({ Exception.class })
        @ResponseBody
        public ErrorMessage exception(Exception exception) {
            exception.printStackTrace();
            return new ErrorMessage(exception);
        }

    }

