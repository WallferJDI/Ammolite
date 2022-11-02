package com.knits.ammolite.repository.building;

import com.knits.ammolite.model.building.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception,Long> {

    Reception findByPhone(String phone);
}
