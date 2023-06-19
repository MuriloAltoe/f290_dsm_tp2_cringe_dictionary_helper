package br.com.muriloaltoe.f290_dsm_tp2_cringe_dictionary_helper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.muriloaltoe.f290_dsm_tp2_cringe_dictionary_helper.model.Palavra;
import br.com.muriloaltoe.f290_dsm_tp2_cringe_dictionary_helper.repositories.PalavraRepository;

@Service
public class PalavraService {

    @Autowired
    private PalavraRepository repository;

    public void adicionar(Palavra palavra) {
        repository.save(palavra);
    }

    public List<Palavra> obterTodas() {
        return repository.findAll();
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    public Palavra obterPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void atualizar(Palavra palavra) {
        Palavra palavraExistente = repository.findById(palavra.getId()).orElse(null);
        if (palavraExistente != null) {
            palavraExistente.setDescricao(palavra.getDescricao());
            palavraExistente.setSignificado(palavra.getSignificado());
            repository.save(palavraExistente);
        }
    }
}