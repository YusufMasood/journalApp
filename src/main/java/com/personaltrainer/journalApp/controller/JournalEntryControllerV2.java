package com.personaltrainer.journalApp.controller;


import com.personaltrainer.journalApp.entity.JournalEntry;
import com.personaltrainer.journalApp.repository.JournalEntryRepository;
import com.personaltrainer.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){

        return null;
    }

    @PostMapping()
    public boolean createEntry(@RequestBody JournalEntry myEntries){
        System.out.println("Received entry: " + myEntries.getTitle());
        journalEntryService.saveEntry(myEntries);
        return true;
    }


    @GetMapping("/id/{myId}")
    public JournalEntry getJournalById(@PathVariable String myId){

        return null;
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteJournalById(@PathVariable String myId){

        return null;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable String id, @RequestBody JournalEntry myEntries){

        return null;
    }

}
