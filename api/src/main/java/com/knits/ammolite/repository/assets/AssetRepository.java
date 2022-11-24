package com.knits.ammolite.repository.assets;


import com.knits.ammolite.model.asset.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssetRepository extends JpaRepository<Asset, Long> {
        Optional<Asset> findById(Long id);
}
