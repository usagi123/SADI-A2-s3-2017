package controller;

import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.QuestionService;
import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    // Create
    @RequestMapping(path = "/questions/create", method = RequestMethod.POST)
    public void saveQuestion(@RequestBody Question question){
        questionService.saveQuestion(question);
    }

    // Read
    @RequestMapping(path = "/questions/getAll", method = RequestMethod.GET)
    public List<Question> getQuestions(){
        return questionService.getAllQuestions();
    }

    @RequestMapping(path="/questions/readByqid/{qid}", method = RequestMethod.GET)
    public Question getQuestionByqid(@PathVariable int qid){
        return questionService.getQuestionByqid(qid);
    }

    @RequestMapping(path="/questions/readByKeyword/{keyword}", method = RequestMethod.GET)
    public List<Question> getQuestionByKeyword(@PathVariable String keyword){
        return questionService.getQuestionByKeyword(keyword);
    }

    // Update
    @RequestMapping(path = "/questions/updateByqid", method = RequestMethod.PATCH)
    public void updateQuestion(@RequestBody Question newQuestion){
        questionService.updateQuestion(newQuestion);
    }

    // Delete
    @RequestMapping(path = "/questions/deleteByqid/{qid}", method =RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable int qid){
        Question question = questionService.getQuestionByqid(qid);
        questionService.deleteQuestion(question);
    }
}