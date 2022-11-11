package com.knits.ammolite.repository.assets;

import com.knits.ammolite.model.asset.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(String name);

}
