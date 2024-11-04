package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    // findAll, save, findById

    @GetMapping
   public String displayAllEvents (Model model) {
       model.addAttribute("events" , eventRepository.findAll());

       return "events/index";
   }

   @GetMapping("create") // lives at /events/create
   public String renderCreateEventForm() {
        return "events/create";
   }

   @PostMapping("create") // it's okay to have the same path as renderCreateEventForm because they handle different types of requests. If they both handled the same type of request they would not be able to have the same path
   public String createNewEvent(@ModelAttribute Event newEvent) { // Form input names must match the names of the fields in the class
        eventRepository.save(newEvent);

        return "redirect:/events"; // Instructs the browser to go to a different page
   }

   @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
   }

   @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
       return "redirect:/events";
   }
}
