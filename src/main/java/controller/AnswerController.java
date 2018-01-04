package controller;

import model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AnswerService;
import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    // Create
    @RequestMapping(path = "/answers/create", method = RequestMethod.POST)
    public void saveAnswer(@RequestBody Answer answer){
        answerService.saveAnswer(answer);
    }

    // Read
    @RequestMapping(path = "/answers/getAll", method = RequestMethod.GET)
    public List<Answer> getAnswers(){
        return answerService.getAllAnswers();
    }

    @RequestMapping(path ="/answers/readByaid/{aid}", method = RequestMethod.GET)
    public Answer getAnswerByaid(@PathVariable int aid){
        return answerService.getAnswerByaid(aid);
    }

    @RequestMapping(path ="/answers/read/{keyword}", method = RequestMethod.GET)
    public List<Answer> getAnswerByKeyword(@PathVariable String keyword){
        return answerService.getAnswerByKeyword(keyword);
    }

    // Update
    @RequestMapping(path = "/answers/updateByaid", method = RequestMethod.PATCH)
    public void updateAnswer(@RequestBody Answer newAnswer){
        answerService.updateAnswer(newAnswer);
    }

    // Delete
    @RequestMapping(path = "/answers/deleteByaid/{aid}", method = RequestMethod.DELETE)
    public void deleteAnswer(@PathVariable int aid){
        Answer answer = answerService.getAnswerByaid(aid);
        answerService.deleteAnswer(answer);
    }
}
