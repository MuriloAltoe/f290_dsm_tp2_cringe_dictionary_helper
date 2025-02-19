package br.com.muriloaltoe.f290_dsm_tp2_cringe_dictionary_helper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.muriloaltoe.f290_dsm_tp2_cringe_dictionary_helper.model.Palavra;
import br.com.muriloaltoe.f290_dsm_tp2_cringe_dictionary_helper.services.PalavraService;

@Controller
@RequestMapping("/dicionario")
public class PalavraController {

    @Autowired
    private PalavraService service;

    @GetMapping
    public String home(Model model) {
        List<Palavra> palavras = service.obterTodas();
        model.addAttribute("titulo", "Vergonha Alheia");
        model.addAttribute("palavras", palavras);
        model.addAttribute("palavra", new Palavra());
        return "dicionario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("palavra") Palavra palavra) {
        service.adicionar(palavra);
        return "redirect:/dicionario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id) {
        service.excluir(id);
        return "redirect:/dicionario/";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Integer id, Model model) {
        Palavra palavraExistente = service.obterPorId(id);
        model.addAttribute("titulo", "Editar Palavra");
        model.addAttribute("palavra", palavraExistente);
        return "formulario-edicao";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("palavra") Palavra palavra) {
        service.atualizar(palavra);
        return "redirect:/dicionario";
    }

    @GetMapping("/inserir")
    public String exibirFormularioInsercao(Model model) {
        model.addAttribute("titulo", "Inserir Palavra");
        model.addAttribute("palavra", new Palavra());
        return "formulario";
    }

    @PostMapping("/inserir")
    public String Inserir(@ModelAttribute("palavra") Palavra palavra) {
        service.adicionar(palavra);
        return "redirect:/dicionario";
    }
}
