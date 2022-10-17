package com.knits.ammolite.service.partners;

import com.knits.ammolite.model.company.BusinessUnit;
import com.knits.ammolite.model.partner.Partner;
import com.knits.ammolite.repository.PartnersRepository;
import com.knits.ammolite.service.dto.company.BusinessUnitDto;
import com.knits.ammolite.service.dto.partner.PartnerDto;
import com.knits.ammolite.service.mapper.partner.PartnerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PartnersService {

    @Autowired
    private PartnerMapper mapper;

    @Autowired
    private PartnersRepository repository;

    public PartnerDto createPartner(PartnerDto partnerDto) {
        log.debug("Request to save Partner : {}", partnerDto);

        final Partner partner = mapper.toEntity(partnerDto);
        repository.save(partner);
        return mapper.toDto(partner);
    }
}
