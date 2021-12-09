package br.com.alura.gerenciador.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import br.com.alura.gerenciador.modelo.Usuario;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioDAO {

    private EntityManager em ;

    public Usuario possuiCadastro(Usuario usuario) throws SQLException {
        return (Usuario) em.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha")
                .setParameter("login", usuario.getLogin()).setParameter("senha", usuario.getSenha()).getSingleResult();
    }
}
