package com.example.module_dev16_home_work.service;

import com.example.module_dev16_home_work.entity.Note;
import com.example.module_dev16_home_work.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
@Slf4j
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note ad(Note note){
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public Note getById(long id){
        return noteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(id + " for note - not found!"));
    }
}
