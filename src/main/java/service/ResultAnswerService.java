package service;

import model.ResultAnswer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultAnswerService {
    @Autowired
    private SessionFactory sessionFactory;

    // Create
    @Transactional
    public void saveResultAnswer(ResultAnswer resultAnswer){
        sessionFactory.getCurrentSession().save(resultAnswer);
    }

    // Read
    @Transactional
    public List<ResultAnswer> getAllResultAnswerss() {
        Query query = sessionFactory.getCurrentSession().createQuery("from ResultAnswer");
        return query.list();
    }

    @Transactional
    public List<ResultAnswer> getResultAnswerssByrid(int rid){
        List<ResultAnswer> resultAnswerss = getAllResultAnswerss();
        List<ResultAnswer> resultAnswersR = new ArrayList<ResultAnswer>();
        for (ResultAnswer resultAnswer:resultAnswerss) {
            if (resultAnswer.getRid() == rid) {
                resultAnswersR.add(resultAnswer);
            }
        }
        return resultAnswersR;
    }

    // Update & Delete
    // Update and Delete result is logically not allowed
}
