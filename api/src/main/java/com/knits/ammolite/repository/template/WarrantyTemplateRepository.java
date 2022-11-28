package com.knits.ammolite.repository.template;

import com.knits.ammolite.model.template.WarrantyTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarrantyTemplateRepository extends JpaRepository<WarrantyTemplate,Long> {
}
