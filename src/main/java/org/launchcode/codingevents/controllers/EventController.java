package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
   public String displayAllEvents (Model model) {
       model.addAttribute("events" , EventData.getAll());

       return "events/index";
   }

   @GetMapping("create") // lives at /events/create
   public String renderCreateEventForm() {
        return "events/create";
   }

   @PostMapping("create") // it's okay to have the same path as renderCreateEventForm because they handle different types of requests. If they both handled the same type of request they would not be able to have the same path
   public String createNewEvent(@RequestParam String eventName,
                                @RequestParam String eventDescription,
                                @RequestParam String eventAddress, @RequestParam String eventImg) {
        EventData.add(new Event(eventName, eventDescription, eventAddress, eventImg));

        return "redirect:/events"; // Instructs the browser to go to a different page
   }

   @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
   }

   @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
       return "redirect:/events";
   }
}
