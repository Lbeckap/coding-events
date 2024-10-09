package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
   public String displayAllEvents (Model model) {
       List<String> eventNames = new ArrayList<>() {{
           add("This event");
           add("That event");
           add("The other event");
       }};

       model.addAttribute("eventNames", eventNames);
       return "events/index";
   }

}
