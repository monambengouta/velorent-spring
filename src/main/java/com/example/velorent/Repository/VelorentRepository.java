package com.example.velorent.Repository;

import com.example.velorent.Entity.Velorent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VelorentRepository extends JpaRepository<Velorent, Long>, JpaSpecificationExecutor<Velorent> {
    List<Velorent> findByStartRentDate(Date startRentDate);

    List<Velorent> findByUserId(Long userId);


}