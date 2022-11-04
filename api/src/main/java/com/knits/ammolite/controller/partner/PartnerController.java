package com.knits.ammolite.controller.partner;

import com.knits.ammolite.service.dto.partner.PartnerDto;
import com.knits.ammolite.service.partners.PartnersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partner")
@Slf4j
public class PartnerController {

    @Autowired
    private PartnersService partnersService;

    @PostMapping(value = "/create", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<PartnerDto> createBusinessUnit(@RequestBody PartnerDto partnerDto) {
        log.debug("REST request to create Partner ");
        return ResponseEntity.ok().body(partnersService.createPartner(partnerDto));
    }
}
