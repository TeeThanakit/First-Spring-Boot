package com.example.mysprintboot.Repository;

import com.example.mysprintboot.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByBreeds(String breeds);

    List<Pet> findByBreedsContainingOrTypeOrderByNameAsc(String breeds, String type);
    List<Pet> findByBirthYearGreaterThan(int birthYear);
    List<Pet> findByNameAndBreedsAndType(String name, String breeds, String type);

    @Query("select p from Pet p WHERE p.name LIKE ?1 AND p.type = ?2")
    List<Pet> findByNameAndTypeJPQL(String name, String type);

    //        Second version
    @Query("select p from Pet p WHERE p.name LIKE :name AND p.type = :type")
    List<Pet> findByNameAndTypeJPQLParam(@Param("name") String name, @Param("type") String type);
}
