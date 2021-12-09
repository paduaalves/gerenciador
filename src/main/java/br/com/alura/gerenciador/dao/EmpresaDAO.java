package br.com.alura.gerenciador.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.alura.gerenciador.modelo.Empresa;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class EmpresaDAO {

    @NonNull
    private Connection connection;
    private EntityManager em = Persistence.createEntityManagerFactory("gerenciador").createEntityManager();

    public void adiciona(Empresa empresa) throws SQLException {
        em.getTransaction().begin();
        em.persist(empresa);
        em.getTransaction().commit();
        em.close();
    }

    public void altera(Empresa empresa) throws SQLException {
        em.getTransaction().begin();
        em.merge(empresa);
        em.getTransaction().commit();
        em.close();
    }

    public List<Empresa> getEmpresas() throws SQLException {
        return (List<Empresa>) em.createQuery("select e from Empresa e ").getResultList();
    }

    public void remove(Integer id) throws SQLException {
        em.getTransaction().begin();
        em.createQuery("delete from Empresa e where e.id = :id").setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
        em.close();
    };

    public Empresa getEmpresa(Integer id) throws SQLException {

        return (Empresa) em.createQuery("select e from Empresa e where e.id = :id").setParameter("id", id)
                .getSingleResult();

    }

}
