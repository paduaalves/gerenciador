package br.com.alura.gerenciador.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.gerenciador.modelo.Empresa;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmpresaDAO {

    private EntityManager em;

    public void adiciona(Empresa empresa) {
        em.getTransaction().begin();
        em.persist(empresa);
        em.getTransaction().commit();
        em.close();
    }

    public void altera(Empresa empresa) {
        em.getTransaction().begin();
        em.merge(empresa);
        em.getTransaction().commit();
        em.close();
    }

    public List<Empresa> getEmpresas() {
        return (List<Empresa>) em.createQuery("select e from Empresa e ").getResultList();
    }

    public void remove(Integer id) {
        em.getTransaction().begin();
        em.createQuery("delete from Empresa e where e.id = :id").setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
        em.close();
    };

    public Empresa getEmpresa(Integer id) {

        return (Empresa) em.createQuery("select e from Empresa e where e.id = :id").setParameter("id", id)
                .getSingleResult();

    }

}
