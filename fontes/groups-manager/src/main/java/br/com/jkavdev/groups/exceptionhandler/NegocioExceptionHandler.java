package br.com.jkavdev.groups.exceptionhandler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class NegocioExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler({ NegocioException.class })
	protected ResponseEntity<Object> handleNegocioException(NegocioException ex, WebRequest req) {
		String userMessage = messageSource.getMessage(ex.getMessage(), null, LocaleContextHolder.getLocale());
		String devMessage = ex.toString();
		List<ErroMessage> erros = Arrays.asList(new ErroMessage(userMessage, devMessage));

		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, req);
	}

}
