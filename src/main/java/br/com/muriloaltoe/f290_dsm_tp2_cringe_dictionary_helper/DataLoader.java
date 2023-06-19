package br.com.muriloaltoe.f290_dsm_tp2_cringe_dictionary_helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.muriloaltoe.f290_dsm_tp2_cringe_dictionary_helper.model.Palavra;
import br.com.muriloaltoe.f290_dsm_tp2_cringe_dictionary_helper.services.PalavraService;

@Component
public class DataLoader implements CommandLineRunner {

    private final PalavraService palavraService;

    @Autowired
    public DataLoader(PalavraService palavraService) {
        this.palavraService = palavraService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Inserção dos dados iniciais
        palavraService.adicionar(new Palavra("de base", "Morrer..."));
        palavraService.adicionar(new Palavra("F", "Prestar condolências."));
        palavraService.adicionar(new Palavra("Não Tankou", "Não aguentou."));
        palavraService.adicionar(new Palavra("Cringe", "25+"));
        palavraService.adicionar(new Palavra("chavoso", "Estiloso, (Gangsta)"));
    }
}
