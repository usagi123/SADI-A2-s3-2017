package service;

import model.Answer;
import model.Question;
import model.QuestionAnswer;
import model.ResultAnswer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class XService {
    private AnswerService answerService = new AnswerService();
    private ResultAnswerService resultAnswerService = new ResultAnswerService();
    private QuestionService questionService = new QuestionService();
    private QuestionAnswerService questionAnswerService = new QuestionAnswerService();

    public List<Question> randomQuestionListGenerator(int lengthOfTest){
        List<Question> questions = questionService.getAllQuestions();
        List<Question> randomizedQuestions = new LinkedList<Question>(questions);
        Collections.shuffle(randomizedQuestions);
        return randomizedQuestions.subList(0, lengthOfTest);
//        Random random = new Random();
//        int sizeOfQuestionDB = questionService.getAllQuestions().size();
//        for (int i = 0; i < lengthOfTest; i++) {
//            int aRandomQuestionID = random.nextInt(sizeOfQuestionDB);
//            Boolean existingCheck = false;
//            for (Question question:questions) {
//                if (question.getQid() == aRandomQuestionID) {
//                    existingCheck = true;
//                    i -= 1;
//                    break;
//                }
//            }
//            if (!existingCheck) {
//                questions.add();
//            }
//        }
//        return questions;
////        long = 15 questions
////        normal = 12 questions
////        short = 8 questions
//        if (testtype.equals("long")) {
//
//        } else if (testtype.equals("normal")) {
//
//        } else if (testtype.equals("short"))
    }

    public List<Answer> getAnswersBasedOnQuestion(Question question){
        List<Answer> answers = new ArrayList<Answer>();
        List<QuestionAnswer> questionAnswerss = questionAnswerService.getQuestionAnswerssByqid(question.getQid());
        for (QuestionAnswer questionAnswer:questionAnswerss) {
            answers.add(answerService.getAnswerByaid(questionAnswer.getAid()));
        }
        return answers;
    }



    public Double scoring(int resultID){
        int numberOfCorrectAnswers = 0;
        List<ResultAnswer> resultAnswerss = resultAnswerService.getResultAnswerssByrid(resultID);
        for (ResultAnswer resultAnswer: resultAnswerss) {
            if (answerService.getAnswerByaid(resultAnswer.getAid()).isCorrectcheck()) {
                numberOfCorrectAnswers += 1;
            }
        }
        return (double) (numberOfCorrectAnswers/(resultAnswerss.size()))*100;
    }
}
