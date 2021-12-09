package br.com.alura.gerenciador.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.alura.gerenciador.modelo.Usuario;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsuarioDAO {

    @NonNull
    private Connection connection;
    private EntityManager em = Persistence.createEntityManagerFactory("gerenciador").createEntityManager();

    public Usuario possuiCadastro(Usuario usuario) throws SQLException {
        return (Usuario) em.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha")
                .setParameter("login", usuario.getLogin()).setParameter("senha", usuario.getSenha()).getSingleResult();

        // String query = "SELECT * FROM usuario WHERE login = ? and senha = ?";
        // PreparedStatement ps = connection.prepareStatement(query);
        // ps.setString(1, usuario.getLogin());
        // ps.setString(2, usuario.getSenha());senha = :senha
        // ResultSet rs = ps.executeQuery();

        // while (rs.next()) {
        // Usuario usuarioLogado = new Usuario(rs.getString(1), rs.getString(2));
        // return usuarioLogado;
        // }
        // return null;
    }
}
