package br.com.jkavdev.groups.domain.integrante;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.groups.event.RecursoCriadoEvent;
import br.com.jkavdev.groups.utils.ServiceMap;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController  implements ServiceMap {

	@Autowired
	private IntegranteService integranteService;
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping(params = "pesquisa")
	private List<Integrante> filtrar(IntegranteFilter filter) {
		return integranteService.filtrar(filter);
	}
	@PutMapping("/{id}/efetivar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void efetivarCadastro(@PathVariable Long id) {
		integranteService.efetivarCadastro(id);
	}
	@PostMapping
	public ResponseEntity<Integrante> criar(@Valid @RequestBody Integrante integrante, HttpServletResponse response) {
		Integrante integranteSalvo = integranteService.salvar(integrante);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, integranteSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(integranteSalvo);
	}
	/***
	 * 
	 * @param cpf
	 * Como o hibernate tem o validador para o @CPF
	 * Temos um servico que recebe uma string como CPF
	 * Quando atribuido o valor ao parametro o hibernate validator
	 * ira validar o valor, sendo obrigatorio um CPF
	 * */
	@PostMapping("/validarcpf")
	@ResponseStatus(HttpStatus.OK)
	public void validarCpf(@Valid @RequestBody IntegranteFilter filter) {
		System.out.println(filter.getCpf() + " eh valido");
	}
//	necessario para realizar a validacao de parametros recebidos pela url
	@Validated
	@GetMapping("{cpf}/validar")
	@ResponseStatus(HttpStatus.OK)
	public void validarCpf(@CPF @PathVariable String cpf) {
		System.out.println(cpf + " eh valido");
	}

}
