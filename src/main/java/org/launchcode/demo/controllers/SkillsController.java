package org.launchcode.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("skills")
public class SkillsController {

    // /skills
    @RequestMapping(value = "")
    @ResponseBody
    public String startSkills(){
        String html = "<h1>Skills Tracker</h1>" +
                "<h2>Skills I Want to Learn</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "<li>CSS</li>" +
                "<li>HTMl</li>" +
                "</ol>" +
                "<a href= '/skills/new'>Add Your Favorite Languages</a>";

        return html;
    }

    @GetMapping(value = "new")
    @ResponseBody
    public String formSkills(){
        String html = "<form method = 'post' action = '/skills/languages'>" +
                "Name:<br>" +
                "<input type = 'text' name = 'name' />" +
                "<br>My favorite language:<br>" +
                "<select name = 'firstChoice'>" +
                "<option value = 'Java'>Java</option>" +
                "<option value = 'JavaScript'>JavaScript</option>" +
                "<option value = 'Python'>Python</option>" +
                "<option value = 'CSS'>CSS</option>" +
                "<option value = 'HTML'>HTML</option>" +
                "</select>" +
                "<br>My second favorite language:<br>" +
                "<select name = 'secondChoice'>" +
                "<option value = 'Java'>Java</option>" +
                "<option value = 'JavaScript'>JavaScript</option>" +
                "<option value = 'Python'>Python</option>" +
                "<option value = 'CSS'>CSS</option>" +
                "<option value = 'HTML'>HTML</option>" +
                "</select>" +
                "<br>My third favorite language:<br>" +
                "<select name = 'thirdChoice'>" +
                "<option value = 'Java'>Java</option>" +
                "<option value = 'JavaScript'>JavaScript</option>" +
                "<option value = 'Python'>Python</option>" +
                "<option value = 'CSS'>CSS</option>" +
                "<option value = 'HTML'>HTML</option>" +
                "</select>" +
                "<br>My fourth favorite language:<br>" +
                "<select name = 'fourthChoice'>" +
                "<option value = 'Java'>Java</option>" +
                "<option value = 'JavaScript'>JavaScript</option>" +
                "<option value = 'Python'>Python</option>" +
                "<option value = 'CSS'>CSS</option>" +
                "<option value = 'HTML'>HTML</option>" +
                "</select>" +
                "<br>My fifth favorite language:<br>" +
                "<select name = 'fifthChoice'>" +
                "<option value = 'Java'>Java</option>" +
                "<option value = 'JavaScript'>JavaScript</option>" +
                "<option value = 'Python'>Python</option>" +
                "<option value = 'CSS'>CSS</option>" +
                "<option value = 'HTML'>HTML</option>" +
                "</select><br>" +
                "<input type= 'submit' value = 'Submit' />" +
                "</form>";
        return html;
    }

    @PostMapping("/languages")
    @ResponseBody
    public String namePage(@RequestParam String name, @RequestParam String firstChoice, @RequestParam String secondChoice, @RequestParam String thirdChoice, @RequestParam String fourthChoice, @RequestParam String fifthChoice){
        String html = "<h1>" + name + "</h1>" +
                "<ol>" +
                "<li>" + firstChoice + "</li>" +
                "<li>" + secondChoice + "</li>" +
                "<li>" + thirdChoice + "</li>" +
                "<li>" + fourthChoice + "</li>" +
                "<li>" + fifthChoice + "</li>" +
                "<ol>";
        return html;
    }
}
