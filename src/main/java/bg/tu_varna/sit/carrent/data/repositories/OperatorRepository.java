package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.Operator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class OperatorRepository implements DAORepositories<Operator> {

    private static final Logger log=Logger.getLogger(OperatorRepository.class);

    public static OperatorRepository getInstance(){return OperatorRepository.OperatorRepositoryHolder.INSTANCE;}

    private static class OperatorRepositoryHolder {
        public static OperatorRepository INSTANCE=new OperatorRepository();
    }

    @Override
    public void save(Operator obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("Operator was saved succesfully.");
        }catch (Exception ex){
            log.error("Operator wasn`t saved , error :("+ ex.getCause());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(Operator obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("Operator was saved succesfully.");
        }catch (Exception ex){
            log.error("Operator wasn`t saved , error :("+ ex.getCause());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(Operator obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Operator was saved succesfully.");
        }catch (Exception ex){
            log.error("Operator wasn`t saved , error :("+ ex.getCause());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public List<Operator> getByIg(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Operator> operators=new LinkedList<Operator>() ;
        try{
            String jpql="SELECT o FROM Operator o WHERE operator_id ="+id;
            operators.addAll(session.createQuery(jpql,Operator.class).getResultList());
            log.info("Succesfully gets all operators");

        }catch (Exception ex){
            log.error("Get ig operator error : "+ex.getCause());
        }finally {
            transaction.commit();
        }
        session.close();
        return operators;
    }

    @Override
    public List<Operator> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Operator> operators=new LinkedList<Operator>() ;
        try{
            String jpql="SELECT o FROM Operator o";
            operators.addAll(session.createQuery(jpql,Operator.class).getResultList());
            log.info("Result all operators");

        }catch (Exception ex){
            log.error("Get operator error : "+ex.getCause());
        }finally {
            transaction.commit();
        }
        session.close();
        return operators;
    }


    public List<Operator> getLogin(String login,String pass){
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Operator>operators =new LinkedList<Operator>() ;
        try{
            String jpql="SELECT t FROM Operator t WHERE t.operator_login= :login AND t.operator_password= :pass ";
            operators.addAll(session.createQuery(jpql, Operator.class).setParameter("login",login).
                    setParameter("pass",pass).  getResultList());
            log.info("Result all admins which matched.");

        }catch (Exception ex){
            log.error("Get admins error : "+ex.getCause());
        }finally {
            transaction.commit();
        }
        session.close();
        return operators;
    }

}