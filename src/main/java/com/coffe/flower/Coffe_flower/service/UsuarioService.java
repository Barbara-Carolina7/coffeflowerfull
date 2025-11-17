package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Usuario;
import com.coffe.flower.Coffe_flower.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> actualizar(Long id, Usuario datos) {
        return usuarioRepository.findById(id).map(user -> {
            user.setNombre(datos.getNombre());
            user.setEmail(datos.getEmail());
            user.setPassword(datos.getPassword());
            user.setTelefono(datos.getTelefono());
            return usuarioRepository.save(user);
        });
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
