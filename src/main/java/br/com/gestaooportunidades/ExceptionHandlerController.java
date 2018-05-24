package br.com.gestaooportunidades;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ModelAndView trataExceptionGenerica(HttpServletRequest req, Exception exception){
        System.out.println("Erro genérico acontecendo");
        exception.printStackTrace();
        ModelAndView modelAndView = new ModelAndView(req.getRequestURI().replace("/", ""));
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
