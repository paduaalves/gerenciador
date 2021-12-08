package br.com.alura.gerenciador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.gerenciador.modelo.Usuario;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioDAO {

    private Connection connection;

    public Usuario possuiCadastro(Usuario usuario) throws SQLException {
        String query = "SELECT * FROM usuario WHERE login = ? and senha = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, usuario.getLogin());
        ps.setString(2, usuario.getSenha());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Usuario usuarioLogado = new Usuario(rs.getString(1), rs.getString(2));
            return usuarioLogado;
        }
        return null;
    }
}
