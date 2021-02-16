package org.launchcode.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("goodbye")
public class GoodbyeController {

    @GetMapping("{name}")
    public String goodbyeWithPathParam( @PathVariable String name){
        return "Goodbye, " + name + "!";
    }

    public String getGoodbye(String name, String language){
        String goodbye = "";
        if (language.equals("english")){
            goodbye = "Goodbye";
        }
        else if(language.equals("french")){
            goodbye = "Au revoir";
        }
        else if(language.equals("spanish")){
            goodbye = "Adios";
        }
        else if(language.equals("norwegian")){
            goodbye = "Ha det";
        }
        else if(language.equals("italian")){
            goodbye = "Arrivederci";
        }

        return goodbye + " " + name;

    }

    // lives at /goodbye
    @RequestMapping(value = "goodbye", method = RequestMethod.GET)
    @ResponseBody
    public String goodbyeGet(@RequestParam String name, @RequestParam String language){
        if(name == null){
            name = "World";
        }
        return getGoodbye(name,language);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String goodbyePost(@RequestParam String name, @RequestParam String language){
        return getGoodbye(name, language);
    }

    //lives at /goodbye/form
    @GetMapping("form")
    public String goodbyeForm(){
        String html = "<form method = 'post' action = '/goodbye'>" +
                "<h1><b><i>Say goodbye to me in a different language!</i></b></h1>" +
                "<b>Your name: </b>" +
                "<input type = 'text' name = 'name' /><br><br>" +
                "<h3><b>Which language would you like to be left with?</b></h3>" +
                "<select name = 'language'>" +
                "<option value = 'english'>English</option>" +
                "<option value = 'french'>French</option>" +
                "<option value = 'spanish'>Spanish</option>" +
                "<option value = 'norwegian'>Norwegian</option>" +
                "<option value = 'italian'>Italian</option>" +
                "</select>\n\n" +
                "<input type = 'submit' value = 'Say goodbye to me!' />" +
                "</form>";
        return html;
    }
}
