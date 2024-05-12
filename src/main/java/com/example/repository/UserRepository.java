package com.example.repository;

import com.example.entity.EntityUser;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.parser.Entity;
import java.util.List;


public interface UserRepository extends CrudRepository<EntityUser, Integer> {
    //쿼리문을 순서대로 검색함
//    @Query("SELECT u FROM EntityUser u WHERE u.UserName=?1")

    //쿼리문을 이름에 맞춰서 검색한다.
    @Query("SELECT u FROM EntityUser u WHERE u.username=:userName")
    List<EntityUser> findUserData(String userName);


    @Query(value = "select * from entity_user where User_Name=:userName ", nativeQuery = true)
    List<EntityUser> findUserDataNative(String userName);

    @Query(value = "select * from entity_user where User_Name=:userName and User_Age=:userAge ", nativeQuery = true)
    List<EntityUser> findUserPass(String userName, String userAge);

    @Modifying
    @Transactional
    @Query(value = "UPDATE EntityUser u SET u.userage = :newAge WHERE u.username = :userName AND u.userage = :userAge")
    int updateUserPass(String userName, String userAge ,String newAge);

    List<EntityUser> findByUsernameAndUserage(String userName, String userAge);

}


