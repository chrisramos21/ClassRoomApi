package com.example.ClassRoomApi.repositories;

import com.example.ClassRoomApi.models.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInscriptionRepository extends JpaRepository<Inscription, Integer> {
}
