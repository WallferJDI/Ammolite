package com.knits.ammolite.service.dto.search;

import com.knits.ammolite.model.company.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
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

    private String name;
    private String alias;

    @Override
    public Specification<Organization> getSpecification() {
        return (root, query, criteriaBuilder) -> {
            query.distinct(true);
            Predicate noFiltersApplied = criteriaBuilder.conjunction();
            List<Predicate> filters = new ArrayList<>();
            filters.add(noFiltersApplied);
            if(StringUtils.isEmpty(name)){
                Predicate organizationNamePredicate = criteriaBuilder
                        .like(root.get("name"),"%"+ name +"%");
                filters.add(organizationNamePredicate);
            }

            if(StringUtils.isEmpty(alias)){
                Predicate organizationNamePredicate = criteriaBuilder
                        .like(root.get("alias"),"%"+ alias +"%");
                filters.add(organizationNamePredicate);
            }
            return criteriaBuilder.and(filters.toArray(new Predicate[filters.size()]));
        };
    }
}
