package com.personaltrainer.journalApp.controller;


import com.personaltrainer.journalApp.entity.JournalEntry;
import com.personaltrainer.journalApp.repository.JournalEntryRepository;
import com.personaltrainer.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        return journalEntryService.findAll();
    }

    @PostMapping()
    public JournalEntry createEntry(@RequestBody JournalEntry myEntries){
        myEntries.setDate(LocalDateTime.now());
        System.out.println("Received entry: " + myEntries.getTitle());
        journalEntryService.saveEntry(myEntries);
        return myEntries;
    }


    @GetMapping("/id/{myId}")
    public JournalEntry getJournalById(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateJournalById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntries){

        JournalEntry old = journalEntryService.findById(myId).orElse(null);

        if(old != null){
            old.setTitle(newEntries.getTitle() != null && !newEntries.getTitle().isEmpty() ? newEntries.getTitle() : old.getTitle());
            old.setContent(newEntries.getContent() != null && !newEntries.getContent().isEmpty() ? newEntries.getContent() : old.getContent());
            System.out.println("Updated entry: " + old.getTitle());
        }
        journalEntryService.saveEntry(old);
        return old;
    }

}
