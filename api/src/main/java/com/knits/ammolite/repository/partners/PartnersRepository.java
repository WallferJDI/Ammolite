package com.knits.ammolite.repository.partners;

import com.knits.ammolite.model.partner.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnersRepository extends JpaRepository<Partner, Long> {
}
