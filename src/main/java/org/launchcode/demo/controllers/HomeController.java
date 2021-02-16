package org.launchcode.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping()
    @ResponseBody
    public String startSkills(){
        String html = "<h1>Welcome to My Site!</h1>" +
                "<a href='/hello/form'>Greetings!<br></a>" +
                "<a href= '/goodbye/form'>Goodbye!<br></a>" +
                "<a href='/skills/new'>Save Your Favorite Languages<br></a>" +
                "<a href= '/skills'>Available Skills<br></a>"
                ;
        return html;
    }
}
