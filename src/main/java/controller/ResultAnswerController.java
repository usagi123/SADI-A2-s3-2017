package controller;

import model.ResultAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ResultAnswerService;

import java.util.List;

@RestController
public class ResultAnswerController {
    @Autowired
    private ResultAnswerService resultAnswerService;

    // Create
    @RequestMapping(path = "/resultAnswerss/create", method = RequestMethod.POST)
    public void saveResultAnswer(@RequestBody ResultAnswer resultAnswer){
        resultAnswerService.saveResultAnswer(resultAnswer);
    }

    // Read
        @RequestMapping(path = "/resultAnswerss/getAll", method = RequestMethod.GET)
    public List<ResultAnswer> getAllResultAnswerss(){
        return resultAnswerService.getAllResultAnswerss();
    }

    @RequestMapping(path="/resultAnswerss/readByrid/{rid}", method = RequestMethod.GET)
    public List<ResultAnswer> getResultAnswerssByrid(@PathVariable int rid){
        return resultAnswerService.getResultAnswerssByrid(rid);
    }

    // Update & Delete
    // Update and Delete result is logically not allowed
}
