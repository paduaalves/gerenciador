package br.com.alura.gerenciador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.modelo.Empresa;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmpresaDAO {

    private Connection connection;

    public void adiciona(Empresa empresa) throws SQLException {
        String query = "INSERT INTO empresa (nome, data_criacao) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, empresa.getNome());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ps.setString(2, sdf.format(empresa.getDataAbertura()));
        ps.execute();
    }

    public void altera(Empresa empresa) throws SQLException {
        String query = "UPDATE empresa set nome = ?,  data_criacao = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, empresa.getNome());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ps.setString(2, sdf.format(empresa.getDataAbertura()));
        ps.setInt(3, empresa.getId());
        ps.execute();
    }

    public List<Empresa> getEmpresas() throws SQLException {
        List<Empresa> empresas = new ArrayList<>();
        String query = "SELECT * FROM empresa";
        PreparedStatement ps = connection.prepareStatement(query);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Empresa empresa = new Empresa(rs.getInt(1), rs.getString(2), rs.getDate(3));
                empresas.add(empresa);
            }
        }
        return empresas;
    }

    public void remove(Integer id) throws SQLException {
        String query = "DELETE FROM empresa WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
    };

    public Empresa getEmpresa(Integer id) throws SQLException {

        String query = "SELECT * FROM empresa WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empresa empresa = new Empresa(rs.getInt(1), rs.getString(2), rs.getDate(3));
                return empresa;
            }
        }
        return null;
    }

}
