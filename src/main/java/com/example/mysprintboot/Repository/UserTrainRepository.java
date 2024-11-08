package com.example.mysprintboot.Repository;

import com.example.mysprintboot.DTO.UserTrainsInt;
import com.example.mysprintboot.Entity.UsersTrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserTrainRepository extends JpaRepository<UsersTrain, Long> {
    List<UsersTrain> findByFirstname(String firstname);
    List<UsersTrain> findByFirstnameAndLastname(String firstname, String lastname);

    @Query("select u from UsersTrain u where u.firstname LIKE ?1")
    List<UsersTrain> getByFirstname(String firstname);

    @Query(value = "SELECT * FROM USERS_TRAIN WHERE firstname = ?1", nativeQuery = true)
    List<UsersTrain> getAllSQL(String firstname);

    @Query(value = "SELECT firstname as name FROM USERS_TRAIN", nativeQuery = true)
    List <UserTrainsInt> getAllByName();
}
