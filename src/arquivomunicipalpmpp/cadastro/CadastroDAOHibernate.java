package arquivomunicipalpmpp.cadastro;

import arquivomunicipalpmpp.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CadastroDAOHibernate implements CadastroDAO
{

    private Session session;
    private Transaction transaction = null;

    @Override
    public void salvar(Cadastro cad)
    {
        session = HibernateUtil.getInstance();
        transaction = session.beginTransaction();
        try
        {
            this.session.save(cad);
            this.transaction.commit();
        } catch (Exception e)
        {
            transaction.rollback();
        } finally
        {
            session.close();
        }
    }

    @Override
    public void atualizar(Cadastro cad)
    {
        session = HibernateUtil.getInstance();
        transaction = session.beginTransaction();
        try
        {
            this.session.update(cad);
            this.transaction.commit();
        } catch (Exception e)
        {
            this.transaction.rollback();
        } finally
        {
            session.close();
        }

    }

    @Override
    public void excluir(Cadastro cad)
    {
        session = HibernateUtil.getInstance();
        transaction = session.beginTransaction();
        try
        {
            this.session.delete(cad);
            this.transaction.commit();
        } catch (Exception e)
        {
            this.transaction.rollback();
        } finally
        {
            session.close();
        }
    }

    @Override
    public List<Cadastro> listar()
    {
        session = HibernateUtil.getInstance();
        transaction = session.beginTransaction();
        try
        {
            return this.session.createCriteria(Cadastro.class).list();
        } catch (Exception e)
        {
            this.transaction.rollback();
        }
        return null;
    }

//    @Override
//    public List<Cadastro> listar()
//    {
//        session = HibernateUtil.getInstance();
//        transaction = session.beginTransaction();
//        try
//        {
//            String hql = "select c from Cadastro c where c.info like :info";
//            Query query = this.session.createQuery(hql);
//            query.setString("info", info);
//            return this.session.createCriteria(Cadastro.class).list();
////            return (List<Cadastro>) query.uniqueResult();
//        } catch (Exception e)
//        {
//            this.transaction.rollback();
//        }
//        return null;
//    }
}
