package controller;

import model.QuestionAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.QuestionAnswerService;

import java.util.List;

@RestController
public class QuestionAnswerController {
    @Autowired
    private QuestionAnswerService questionAnswerService;

    // Create
    @RequestMapping(path = "/questionAnswerss/create", method = RequestMethod.POST)
    public void saveQuestionAnswer(@RequestBody QuestionAnswer questionAnswer){
        questionAnswerService.saveQuestionAnswer(questionAnswer);
    }

    // Read
    @RequestMapping(path = "/questionAnswerss/getAll", method = RequestMethod.GET)
    public List<QuestionAnswer> getAllQuestionAnswerss(){
        return questionAnswerService.getAllQuestionAnswerss();
    }

    @RequestMapping(path="/questionAnswerss/readByqid/{qid}", method = RequestMethod.GET)
    public List<QuestionAnswer> getQuestionAnswerssByqid(@PathVariable int qid){
        return questionAnswerService.getQuestionAnswerssByqid(qid);
    }

    @RequestMapping(path="/questionAnswerss/readByaid/{aid}", method = RequestMethod.GET)
    public QuestionAnswer getQuestionAnswerByaid(@PathVariable int aid){
        return questionAnswerService.getQuestionAnswerByaid(aid);
    }

    // Update
    @RequestMapping(path = "/questionAnswerss/updateByaid", method = RequestMethod.PATCH)
    public void updateqidOfQuestionAnswerByaid(@RequestBody QuestionAnswer questionAnswerWithNewqid){
        questionAnswerService.updateqidOfQuestionAnswerByaid(questionAnswerWithNewqid);
    }

    @RequestMapping(path = "/questionAnswerss/updateByqid/{newaid}", method = RequestMethod.PATCH)
    public void updateaidOfQuestionAnswerByqid(@RequestBody QuestionAnswer oldQuestionAnswer, @PathVariable int newaid){
        questionAnswerService.updateaidOfQuestionAnswerByqid(oldQuestionAnswer, newaid);
    }

    // Delete
    @RequestMapping(path = "/questionAnswerss/delete/{aid}", method =RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable int aid){
        QuestionAnswer questionAnswer = questionAnswerService.getQuestionAnswerByaid(aid);
        questionAnswerService.deleteQuestionAnswer(questionAnswer);
    }
}
