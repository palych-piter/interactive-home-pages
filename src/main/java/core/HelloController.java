package core;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HelloController {


    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello Initial Page!");
        return "index";
    }


    @RequestMapping(value = "ListOfMessages", method = RequestMethod.GET)
    public String ListOfMessages(ModelMap model) {
        model.addAttribute("message", "This is a list of messages!");
        return "ListOfMessages";
    }


    @RequestMapping(value = "ListOfUsers", method = RequestMethod.GET)
    public String ListOfUsers(ModelMap model) {
        model.addAttribute("message", "This is a list of users!");
        return "ListOfUsers";
    }


    @RequestMapping(value = "ListOfMessages", method = RequestMethod.POST)
    public String ListOfMessages(ModelMap model,
                                 @RequestParam(value = "user") String value1,
                                 @RequestParam(value = "message") String value2) {
        model.addAttribute("message", "Adding a new message : " +
                value1 + "/" + value2);
        return "ListOfMessages";
    }


}