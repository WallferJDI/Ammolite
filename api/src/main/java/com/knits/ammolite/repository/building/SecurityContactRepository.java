package com.knits.ammolite.repository.building;

import com.knits.ammolite.model.building.SecurityContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityContactRepository extends JpaRepository<SecurityContact,Long> {

    SecurityContact findByPhone(String phone);

}
