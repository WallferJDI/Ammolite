package com.knits.ammolite.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.knits.ammolite.util.Consts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AbstractSearchableDto<T> implements Searchable<T>{
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer limit;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer page;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String sort;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Sort.Direction dir;


    @Override
    public Specification getSpecification() {
        return null;
    }

    @Override
    @JsonIgnore
    public Pageable getPageable() {
        return PageRequest.of(
                (page != null) ? page : 0,
                (limit != null && limit >= 0) ? limit : Consts.DEFAULT_JPA_PAGE_SIZE,
                getSortSpec()
        );
    }

    @Override
    @JsonIgnore
    public Sort getSortSpec() {
        if (sort == null) return Sort.unsorted();
        return (dir != null && dir == Sort.Direction.DESC) ?
                Sort.by(sort).descending() : Sort.by(sort).ascending();
    }
}
