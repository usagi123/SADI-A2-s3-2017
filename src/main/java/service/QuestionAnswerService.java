package service;

import model.Question;
import model.QuestionAnswer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionAnswerService {
    @Autowired
    private SessionFactory sessionFactory;

    // Create
    @Transactional
    public void saveQuestionAnswer(QuestionAnswer questionAnswer){
        sessionFactory.getCurrentSession().save(questionAnswer);
    }

    // Read
    @Transactional
    public List<QuestionAnswer> getAllQuestionAnswerss() {
        Query query = sessionFactory.getCurrentSession().createQuery("from QuestionAnswer");
        return query.list();
    }

    @Transactional
    public List<QuestionAnswer> getQuestionAnswerssByqid(int qid){
        List<QuestionAnswer> questionAnswers = getAllQuestionAnswerss();
        List<QuestionAnswer> questionAnswerResult = new ArrayList<QuestionAnswer>();
        for (QuestionAnswer questionAnswer:questionAnswers) {
            if (questionAnswer.getQid() == qid) {
                questionAnswerResult.add(questionAnswer);
            }
        }
        return questionAnswerResult;
    }

//    @Transactional
//    public QuestionAnswer getQuestionAnswerByaid(int aid){
//        List<QuestionAnswer> questionAnswers = getAllQuestionAnswerss();
//        QuestionAnswer questionAnswerResult = new QuestionAnswer();
//        for (QuestionAnswer questionAnswer:questionAnswers) {
//            if (questionAnswer.getAid() == aid) {
//                questionAnswerResult = questionAnswer;
//            }
//        }
//        return questionAnswerResult;
//    }

    @Transactional
    public QuestionAnswer getQuestionAnswerByaid(int aid){
        return (QuestionAnswer) sessionFactory.getCurrentSession().get(QuestionAnswer.class, aid);
    }

    // Update
    @Transactional
    public void updateqidOfQuestionAnswerByaid(QuestionAnswer questionAnswerWithNewqid){
        QuestionAnswer questionAnswer = getQuestionAnswerByaid(questionAnswerWithNewqid.getAid());
        questionAnswer.setQid(questionAnswerWithNewqid.getQid());
        sessionFactory.getCurrentSession().update(questionAnswer);
    }

    @Transactional
    public void updateaidOfQuestionAnswerByqid(QuestionAnswer oldQuestionAnswer, int newaid){
        QuestionAnswer questionAnswer = getQuestionAnswerByaid(oldQuestionAnswer.getAid());
        questionAnswer.setAid(newaid);
        sessionFactory.getCurrentSession().update(questionAnswer);
    }

    // Delete
    @Transactional
    public void deleteQuestionAnswer(QuestionAnswer questionAnswer){
        sessionFactory.getCurrentSession().delete(questionAnswer);
    }

}
