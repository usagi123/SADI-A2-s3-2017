package controller;

import model.Answer;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.XService;

import java.util.List;

@RestController
public class XController {
    @Autowired
    private XService xService;

    @RequestMapping(path = "/x/questionGenerator/{length}", method = RequestMethod.GET)
    public List<Question> randomQuestionListGenerator(@PathVariable int length) {
        return xService.randomQuestionListGenerator(length);
    }

    @RequestMapping(path = "/x/getAnswers", method = RequestMethod.POST)
    public List<Answer> getAnswersBasedOnQuestion(@RequestBody Question question){
        return xService.getAnswersBasedOnQuestion(question);
    }

    @RequestMapping(path = "/x/scoring/{resultid}", method = RequestMethod.GET)
    public Double scoring(@PathVariable int resultid) {
        return xService.scoring(resultid);
    }
}
