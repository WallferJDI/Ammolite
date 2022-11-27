package com.knits.ammolite.repository.assets;

import com.knits.ammolite.model.asset.AssetCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssetCategoryRepository extends JpaRepository<AssetCategory,Long> {
    Boolean existsByName(String name);
    Optional<AssetCategory> findByName(String name);
}
