package br.com.jkavdev.groups.domain.noticia.service;

import br.com.jkavdev.groups.domain.noticia.entity.Noticia;
import br.com.jkavdev.groups.domain.noticia.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    public Noticia salvar(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

}
