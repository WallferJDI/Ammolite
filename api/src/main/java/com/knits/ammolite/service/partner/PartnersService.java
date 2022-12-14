package com.knits.ammolite.service.partner;

import com.knits.ammolite.model.partner.Partner;
import com.knits.ammolite.repository.partners.PartnersRepository;
import com.knits.ammolite.dto.partner.PartnerDto;
import com.knits.ammolite.mapper.partner.PartnerMapper;
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
