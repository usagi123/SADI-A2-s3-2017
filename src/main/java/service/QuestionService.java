package service;

import model.Question;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private SessionFactory sessionFactory;

    // Create
    @Transactional
    public void saveQuestion(Question question){
        sessionFactory.getCurrentSession().save(question);
    }

    // Read
    @Transactional
    public List<Question> getAllQuestions() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Question");
        return query.list();
    }

//    @Transactional
//    public Question getQuestionByqid(int qid){
//        List<Question> questions = getAllQuestions();
//        Question questionResult = new Question();
//        for (Question question:questions) {
//            if (question.getQid() == qid) {
//                questionResult = question;
//            }
//        }
//        return questionResult;
//    }

    @Transactional
    public Question getQuestionByqid(int qid){
        return (Question) sessionFactory.getCurrentSession().get(Question.class, qid);
    }

    @Transactional
    public List<Question> getQuestionByKeyword(String keyword){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Question.class);
        criteria.add(Restrictions.like("question", keyword, MatchMode.ANYWHERE));
        return criteria.list();
    }

    // Update
    @Transactional
    public void updateQuestion(Question newQuestion){
        Question question = getQuestionByqid(newQuestion.getQid());
        question.setQuestion(newQuestion.getQuestion());
        sessionFactory.getCurrentSession().update(question);
    }

    // Delete
    @Transactional
    public void deleteQuestion(Question question){
        sessionFactory.getCurrentSession().delete(question);
    }
}
