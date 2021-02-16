package org.launchcode.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @GetMapping("{name}")
    public String helloWithPathParam( @PathVariable String name){
        return "Hello, " + name + "!";
    }

    public String getGreeting(String name, String language){
        String greeting = "";
        if (language.equals("english")){
            greeting = "Hello";
        }
        else if(language.equals("french")){
            greeting = "Bonjour";
        }
        else if(language.equals("spanish")){
            greeting = "Hola";
        }
        else if(language.equals("norwegian")){
            greeting = "Hallo";
        }
        else if(language.equals("italian")){
            greeting = "Bonjourno";
        }

        return greeting + " " + name;
    }

    // /hello
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloGet(@RequestParam String name, @RequestParam String language){
        if (name == null){
            name = "World";
        }
        return getGreeting(name, language);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language){
        return getGreeting(name, language);
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        String html = "<form method = 'post' action = '/hello'>" +
                "<h1><b><i>Greet me in a different language!</i></b></h1>" +
                "<b>Your name: </b>" +
                "<input type = 'text' name = 'name' /><br><br>" +
                "<h3><b>Which language would you like to be greeted in?</b></h3>" +
                "<select name = 'language'>" +
                "<option value = 'english'>English</option>" +
                "<option value = 'french'>French</option>" +
                "<option value = 'spanish'>Spanish</option>" +
                "<option value = 'norwegian'>Norwegian</option>" +
                "<option value = 'italian'>Italian</option>" +
                "</select>\n\n" +
                "<input type = 'submit' value = 'Greet me!' />" +
                "</form>";
        return html;
    }

}
