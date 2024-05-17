package com.example.service;

import com.example.dto.DTOBoard;
import com.example.entity.EntityBoard;
import com.example.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBoard {

    @Autowired
    BoardRepository boardRepo;

    public Iterable<EntityBoard> GetAllBoard(){
        return boardRepo.findAll();
    }



}
