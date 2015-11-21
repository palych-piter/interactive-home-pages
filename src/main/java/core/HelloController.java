
package core;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.MessageService;

@Controller
@RequestMapping("/")
public class HelloController {


    private MessageService messageService;

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


    //@RequestMapping(value = "ListOfMessages", method = RequestMethod.POST)
    //public String ListOfMessages(ModelMap model,
    //                             @RequestParam(value = "user") String value1,
    //                             @RequestParam(value = "message") String value2) {
    //    model.addAttribute("message", "Adding a new message : " +
    //            value1 + "/" + value2);

    //this.personService.addPerson(p);

    //    return "ListOfMessages";
    //}


    @RequestMapping(value = "ListOfMessages", method = RequestMethod.POST)
    public String addMessage(@ModelAttribute("Message") Message p) {


        if (p.getid() == 0) {
            //new message, add it
            //System.out.printf("Content of the message/prior to execute" +
            //        "the addMessage method" + p.getcontent());


            this.messageService.addMessage(p);
            //System.out.printf("Content of the message" + p.getcontent());

        } else {
            //existing message, call update
            this.messageService.updateMessage(p);
        }
        return "ListOfMessages";
    }
}