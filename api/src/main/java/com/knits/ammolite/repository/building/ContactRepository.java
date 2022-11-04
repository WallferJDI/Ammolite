package com.knits.ammolite.repository.building;

import com.knits.ammolite.model.location.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    Contact findByPhone(String phone);
}
