package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {


    List<Whisky> findWhiskyByYear(int year);

    List<Whisky> findWhiskiesByDistilleryNameAndAge(String distilleryName, Integer age);

}
