package br.com.jkavdev.groups.domain.integrante.controller;

import br.com.jkavdev.groups.domain.integrante.dto.IntegranteDTO;
import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import br.com.jkavdev.groups.domain.integrante.repository.IntegranteFilter;
import br.com.jkavdev.groups.domain.integrante.service.IntegranteService;
import br.com.jkavdev.groups.event.RecursoCriadoEvent;
import br.com.jkavdev.groups.utils.ServiceMap;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController implements ServiceMap {

    @Autowired
    private IntegranteService integranteService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping(params = "pesquisa")
    public List<IntegranteDTO> filtrar(IntegranteFilter filter) {
        return integranteService.filtrar(filter);
    }

    @GetMapping("{id}")
    public IntegranteDTO buscarPor(@PathVariable Long id) {
        return IntegranteDTO.from(integranteService.buscarPeloId(id));
    }

    @PutMapping("/{id}/efetivar")
    @ResponseStatus(NO_CONTENT)
    public void efetivarCadastro(@PathVariable Long id) {
        integranteService.efetivarCadastro(id);
    }

    @PostMapping
    public ResponseEntity<IntegranteDTO> criar(@Valid @RequestBody IntegranteDTO dto, HttpServletResponse response) {
        Integrante integranteSalvo = integranteService.salvar(Integrante.from(dto));
        publisher.publishEvent(new RecursoCriadoEvent(this, response, integranteSalvo.getId()));
        return ResponseEntity.status(CREATED).body(Integrante.toDTO(integranteSalvo));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void remover(@PathVariable("id") Long id) {
        integranteService.remover(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IntegranteDTO> atualizar(@PathVariable Long id, @Valid @RequestBody IntegranteDTO dto) {
        integranteService.atualizar(id, Integrante.from(dto));
        return ResponseEntity.ok(dto);
    }

    /***
     * @param filter
     * Como o hibernate tem o validador para o @CPF
     * Temos um servico que recebe uma string como CPF
     * Quando atribuido o valor ao parametro o hibernate validator
     * ira validar o valor, sendo obrigatorio um CPF
     * */
    @PostMapping("/validarcpf")
    @ResponseStatus(OK)
    public void validarCpf(@Valid @RequestBody IntegranteFilter filter) {
        System.out.println(filter.getCpf() + " eh valido");
    }

    //	necessario para realizar a validacao de parametros recebidos pela url
    @Validated
    @GetMapping("{cpf}/validar")
    @ResponseStatus(OK)
    public void validarCpf(@CPF @PathVariable String cpf) {
        System.out.println(cpf + " eh valido");
    }

}
