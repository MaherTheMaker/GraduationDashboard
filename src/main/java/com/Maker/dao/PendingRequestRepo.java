package com.Maker.dao;

import com.Maker.model.PendingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingRequestRepo extends JpaRepository<PendingRequest,Integer> {

    PendingRequest findById(int id);
}
