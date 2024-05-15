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

    public void Write(DTOBoard board){
        System.out.println("Service Board Write");
        System.out.println(board.Title);
        System.out.println(board.Author);
        System.out.println(board.Content);
        boardRepo.save(board.ToEntity());
    }


}
