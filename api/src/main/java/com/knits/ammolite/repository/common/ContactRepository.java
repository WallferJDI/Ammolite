package com.knits.ammolite.repository.common;

import com.knits.ammolite.model.common.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
