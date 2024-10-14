package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("events")
public class EventController {

    private static Map<String, String> events = new HashMap<>();
    private static String url;

    @GetMapping
   public String displayAllEvents (Model model) {
       model.addAttribute("events" , events);
       model.addAttribute("imgUrl", url);
       return "events/index";
   }

   @GetMapping("create") // lives at /events/create
   public String renderCreateEventForm() {
        return "events/create";
   }

   @PostMapping("create") // it's okay to have the same path as renderCreateEventForm because they handle different types of requests. If they both handled the same type of request they would not be able to have the same path
   public String createNewEvent(@RequestParam String eventName, @RequestParam String eventDescription, @RequestParam String imgUrl) {
        events.put(eventName, eventDescription);
        url = imgUrl;

        return "redirect:/events"; // Instructs the browser to go to a different page
   }
}
