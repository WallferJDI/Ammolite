package com.knits.ammolite.search;

import com.knits.ammolite.model.location.Location;
import com.knits.ammolite.model.location.OwnershipType;
import com.knits.ammolite.model.location.RealEstateType;
import org.springframework.data.jpa.domain.Specification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LocationSearchDto extends AbstractSearchableDto<Location> {

    private String title;

    private Long countryId;
    private String address;
    private String zipCode;
    private String ownership;
    private String realEstate;



    @Override
    public Specification<Location> getSpecification() {

        return (root, query, criteriaBuilder) -> {

            query.distinct(true);
            Predicate noFiltersApplied = criteriaBuilder.conjunction();
            List<Predicate> filters = new ArrayList<>();
            filters.add(noFiltersApplied);

            if (Strings.isNotBlank(title)) {
                Predicate titleAsPredicate = criteriaBuilder.like(root.get("title"), "%" + title + "%");
                filters.add(titleAsPredicate);
            }

            if (countryId != null) {
                Predicate countryIdAsPredicate = criteriaBuilder.equal(root.get("country").get("id"), countryId);
                filters.add(countryIdAsPredicate);}

            if (Strings.isNotBlank(address)) {
                Predicate addressAsPredicate = criteriaBuilder.like(root.get("address"), "%" + address + "%");
                filters.add(addressAsPredicate);
            }

            if (Strings.isNotBlank(zipCode)) {
                Predicate zipCodeAsPredicate = criteriaBuilder.like(root.get("zipCode"), "%" + zipCode + "%");
                filters.add(zipCodeAsPredicate);
            }

            if (Strings.isNotBlank(ownership)) {
                Predicate ownershipAsPredicate = criteriaBuilder.equal(root.get("ownership"), OwnershipType.valueOf(ownership));
                filters.add(ownershipAsPredicate);
            }

            if (Strings.isNotBlank(realEstate)) {
                Predicate realEstateAsPredicate = criteriaBuilder.equal(root.get("realEstate"), RealEstateType.valueOf(realEstate));
                filters.add(realEstateAsPredicate);
            }

            return criteriaBuilder.and(filters.toArray(new Predicate[filters.size()]));
        };
    }
}
