package com.knits.ammolite.repository.assets;


import com.knits.ammolite.model.asset.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {

}