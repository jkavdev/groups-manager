package br.com.jkavdev.groups.domain.noticia.service;

import br.com.jkavdev.groups.domain.noticia.entity.Noticia;
import br.com.jkavdev.groups.domain.noticia.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    public Noticia buscarPor(Long id) {
        Optional<Noticia> noticia = noticiaRepository.findById(id);
        noticia.orElseThrow(() -> new EmptyResultDataAccessException(1));
        return noticia.get();
    }

    public Noticia salvar(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    public void remover(Long id) {
        noticiaRepository.deleteById(id);
    }

    public void marcar(Long id, boolean util) {
        Optional<Noticia> noticiaOp = noticiaRepository.comInformacoesUtil(id);
        noticiaOp.orElseThrow(() -> new EmptyResultDataAccessException(1));

        Noticia noticia = noticiaOp.get();
        noticia.marcar(util);
        noticiaRepository.save(noticia);
    }

}
