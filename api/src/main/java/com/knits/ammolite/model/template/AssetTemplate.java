package com.knits.ammolite.model.template;

import com.knits.ammolite.model.asset.Asset;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "asset_template")
@Entity
@Data
public class AssetTemplate extends Asset {
}
