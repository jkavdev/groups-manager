package br.com.jkavdev.groups.domain.integrante;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class IntegranteService {

	@Autowired
	private IntegranteRepository integranteRepository;

	public void efetivarCadastro(Long id) {
		Integrante integrante = buscarPeloId(id);
		integrante.efetivarCadastro();
		integranteRepository.save(integrante);
	}

	public Integrante buscarPeloId(Long id) {
		Optional<Integrante> integrante = integranteRepository.findById(id);

		if (!integrante.isPresent())
			throw new EmptyResultDataAccessException(1);

		return integrante.get();
	}

	public Integrante salvar(Integrante integrante) {
		return integranteRepository.save(integrante);
	}

	public List<Integrante> filtrar(IntegranteFilter filter) {
		return integranteRepository.filtrar(filter);
	}

}
