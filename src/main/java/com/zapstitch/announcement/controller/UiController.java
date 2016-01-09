package com.zapstitch.announcement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user-1 on 23/12/15.
 */
@Controller
@RequestMapping(value = "/ui")
public class UiController {

    @RequestMapping("/announcements")
    public String getAnnouncementsPage() {
        return "announcements";
    }
}
