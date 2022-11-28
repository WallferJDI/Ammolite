package com.knits.ammolite.model.template;

import com.knits.ammolite.model.asset.Depreciation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "depreciation_template")
@Entity
@Data
public class DepreciationTemplate extends Depreciation {
}
