package br.com.alura.gerenciador.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.gerenciador.modelo.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha ")
    @Transactional(readOnly = true)
    Usuario findByLoginAndSenha(String login, String senha);

}
