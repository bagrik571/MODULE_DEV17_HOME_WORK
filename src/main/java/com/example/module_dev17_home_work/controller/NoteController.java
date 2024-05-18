package com.example.module_dev17_home_work.controller;

import com.example.module_dev17_home_work.dto.NoteDto;
import com.example.module_dev17_home_work.entity.Note;
import com.example.module_dev17_home_work.entity.User;
import com.example.module_dev17_home_work.service.NoteService;
import com.example.module_dev17_home_work.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;
@Controller
@Validated
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ModelAndView noteList() {
        ModelAndView result = new ModelAndView("note/list");
        List<Note> notes = noteService.listAll();
        result.addObject("notes", notes);
        result.addObject("note", new Note());
        return result;
    }

    @RequestMapping(value = "/edit", method ={RequestMethod.GET})
    public ModelAndView getNoteForUpdate(
            @NotNull
            @RequestParam(value = "id") Long id){
        ModelAndView result = new ModelAndView("note/edit");
        Note note = noteService.getById(id);
        result.addObject("note", note);
        return result;
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.POST})
    public ModelAndView updateNote(
            @NotNull
            @RequestParam(value = "id") Long id,
            @NotNull
            @Size(min = 1, max = 150)
            @RequestParam(value = "title") String title,
            @NotNull
            @RequestParam(value = "content") String content) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }
@RequestMapping(value = "/create", method = {RequestMethod.POST})
public ModelAndView createNote(
        @CookieValue(value="userId") Long userId,
        @RequestParam(value = "title") @Size(min = 1, max = 150) String title,
        @RequestParam(value = "content") String content){
    Note note = new Note();
    note.setId(new Random().nextLong());
    note.setTitle(title);
    note.setContent(content);
    note.setUser(new User(note.getId()));

    noteService.ad(note);
    return new ModelAndView("redirect:/note/list");
}


    @DeleteMapping
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public ModelAndView deleteNoteById(@Valid @NotNull @RequestParam(value = "id") Long id) {
        noteService.deleteById(id);
        return new ModelAndView("redirect:/note/list");
    }
}
