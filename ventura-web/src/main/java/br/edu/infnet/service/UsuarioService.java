package br.edu.infnet.service;

import br.edu.infnet.domain.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url="http://localhost:8081/usuarios",name="usuarioService")
public interface UsuarioService {

    @GetMapping(value = "/email/{email}")
    Usuario pegarPorEmail(@PathVariable("email")String email);

    @GetMapping(value="/id/{id}")
    Usuario pegarPorId(String id);

    @PostMapping
    Usuario criarUsuario(Usuario usuario);
}
