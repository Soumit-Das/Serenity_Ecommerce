package com.serenity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serenity.model.Feedback;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}
