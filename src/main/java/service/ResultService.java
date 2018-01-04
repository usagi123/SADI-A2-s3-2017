package service;

import model.Result;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    private SessionFactory sessionFactory;

    // Create
    @Transactional
    public void saveResult(Result result){
        sessionFactory.getCurrentSession().save(result);
    }

    // Read
    @Transactional
    public List<Result> getAllResults() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Result");
        return query.list();
    }

//    @Transactional
//    public Result getResultByrid(int rid){
//        List<Result> results = getAllResults();
//        Result resultR = new Result();
//        for (Result result:results) {
//            if (result.getRid() == rid) {
//                resultR = result;
//            }
//        }
//        return resultR;
//    }

    @Transactional
    public Result getResultByrid(int rid){
        return (Result) sessionFactory.getCurrentSession().get(Result.class, rid);
    }

    // Update & Delete
    // Update and Delete result is logically not allowed
}
