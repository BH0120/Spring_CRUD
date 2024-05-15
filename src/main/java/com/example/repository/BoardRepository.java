package com.example.repository;

import com.example.entity.EntityBoard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<EntityBoard, Integer> {
}
