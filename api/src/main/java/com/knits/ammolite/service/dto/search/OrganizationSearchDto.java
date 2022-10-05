package com.knits.ammolite.service.dto.search;

import com.knits.ammolite.model.organization.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationSearchDto extends AbstractSearchableDto<Organization>{

    private String organizationName;
    private String organizationAlias;

    @Override
    public Specification<Organization> getSpecification() {
        return (root, query, criteriaBuilder) -> {
            query.distinct(true);
            Predicate noFiltersApplied = criteriaBuilder.conjunction();
            List<Predicate> filters = new ArrayList<>();
            filters.add(noFiltersApplied);
            if(organizationName != null && !organizationName.isEmpty()){
                Predicate organizationNamePredicate = criteriaBuilder
                        .like(root.get("organizationName"),"%"+organizationName+"%");
                filters.add(organizationNamePredicate);
            }

            if(organizationAlias != null && !organizationAlias.isEmpty()){
                Predicate organizationNamePredicate = criteriaBuilder
                        .like(root.get("organizationAlias"),"%"+organizationAlias+"%");
                filters.add(organizationNamePredicate);
            }
            return criteriaBuilder.and(filters.toArray(new Predicate[filters.size()]));
        };
    }
}
