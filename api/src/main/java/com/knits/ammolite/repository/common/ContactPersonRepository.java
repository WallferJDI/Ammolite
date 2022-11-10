package com.knits.ammolite.repository.common;

import com.knits.ammolite.model.common.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson,Long> {

    ContactPerson findByPhone(String phone);
}
