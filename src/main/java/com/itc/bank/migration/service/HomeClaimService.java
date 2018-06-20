package com.itc.bank.migration.service;

import com.itc.bank.migration.entity.destination.DHomeClaim;
import com.itc.bank.migration.entity.source.SHomeClaim;
import com.itc.bank.migration.repository.command.HomeClaimRepository;
import com.itc.bank.migration.repository.query.SHomeClaimRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
public class HomeClaimService {

    private final static Logger logger = Logger.getLogger(HomeClaimService.class);
    @Autowired
    private SHomeClaimRepository sHomeClaimRepository;
    @Autowired
    private HomeClaimRepository homeClaimRepository;

    public void migrateHomeClaim() {
        logger.info("About to migrate table RS_HOME_CLAIM");
        List<SHomeClaim> sHomeClaims = (List<SHomeClaim>) sHomeClaimRepository.findAll();
        logger.debug("Query successful for table: RS_HOME_CLAIM and size: {} " + sHomeClaims.size());
        saveHomeClaim(sHomeClaims);
        logger.debug("RS_HOME_CLAIM migrated successfully time: " + new Date());
    }

    @Transactional(propagation = REQUIRED)
    public void saveHomeClaim(List<SHomeClaim> sHomeClaims) {
        sHomeClaims.stream().forEach(sHomeClaim -> homeClaimRepository.save(buildHomeClaim(sHomeClaim)));
    }

    private DHomeClaim buildHomeClaim(SHomeClaim sHomeClaim) {
        return DHomeClaim.builder()
                .id(Integer.parseInt(sHomeClaim.getId()))
                .claimNature(sHomeClaim.getClaimNature())
                .claimAmount(sHomeClaim.getClaimAmount())
                .policyNo(sHomeClaim.getPolicyNumber())
                .emailId(sHomeClaim.getEmailId())
                .mobileNo(sHomeClaim.getMobileNumber())
                .resNo(sHomeClaim.getResNo())
                .offNo(sHomeClaim.getOffNo())
                .address(sHomeClaim.getAddress())
                .regDate(sHomeClaim.getRegDate())
                // .lossDate(sHomeClaim.getLossDate()) // TODO is source date is as string need to use dateformat
                //  .name(sHomeClaim.) //TODO Name field not available in source
                .createDate(sHomeClaim.getRegDate())
                .build();
    }
}
