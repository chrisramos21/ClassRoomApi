package com.example.ClassRoomApi.repositories;

import com.example.ClassRoomApi.models.Assistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssistanceRepository extends JpaRepository<Assistance, Integer> {

}
