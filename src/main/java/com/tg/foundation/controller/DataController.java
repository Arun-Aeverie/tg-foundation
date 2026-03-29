package com.tg.foundation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tg.foundation.model.User;
import com.tg.foundation.repository.UserRepository;

@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private UserRepository userRepository;

    // PRODUCES JSON or XML based on the "Accept" header
    @GetMapping(value = "/api/{id}", produces = {"application/json", "application/xml"})
    @ResponseBody
    public User getApiData(@PathVariable Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    // RENDERS HTML for the browser
    @GetMapping("/view/{id}")
    public String getHtmlView(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).orElse(new User()));
        return "userProfile";
    }

    // CONCEPTUAL: Triggering a Data Lake Export (Parquet)
    @PostMapping("/export/parquet")
    @ResponseBody
    public String exportToLake() {
        // Engineering Logic: Stream RDBMS -> Convert to Columnar -> Write to .parquet
        return "201 Created: Data batch moving to S3 as PARQUET";
    }
}