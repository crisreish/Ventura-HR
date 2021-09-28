package br.edu.infnet.controller;

import br.edu.infnet.domain.Criterio;
import br.edu.infnet.domain.Usuario;
import br.edu.infnet.domain.Vaga;
import br.edu.infnet.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping("/postarVaga")
    public String formVaga() {
        return "/empresa/postarVaga";
    }

    @PostMapping(value = "/empresa/vaga")
    public ModelAndView cadastrarVaga(Vaga vaga, HttpServletRequest request) {
        ModelAndView resposta = new ModelAndView("/empresa/postarVaga");
        HttpSession session = request.getSession();
        session.setAttribute("vaga", vaga);
        return resposta;
    }

    @PostMapping(value = "/empresa/criterios")
    public ModelAndView cadastrarCriterios(Criterio criterio, HttpServletRequest request) {
        ModelAndView resposta = new ModelAndView("/empresa/postarVaga");
        HttpSession session = request.getSession();
        List criterios = (List) session.getAttribute("criterios");

        if (criterios == null) {
            criterios = new ArrayList<>();
        }
        criterios.add(criterio);
        session.setAttribute("criterios", criterios);
        return resposta;
    }

    @PostMapping(value = "/empresa/anunciarVaga")
    public String postarVaga(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Vaga vaga = (Vaga) session.getAttribute("vaga");
        List criterios = (List) session.getAttribute("criterios");
        vaga.setCriterioList(criterios);
        vagaService.publicarVaga(vaga);
        List<Vaga> vagas = vagaService.listarVagaPorUsuarioId(usuario.getId());
        model.addAttribute("vagas", vagas);

        session.removeAttribute("vaga");
        session.removeAttribute("criterios");

        return "/empresa/home";
    }
}
