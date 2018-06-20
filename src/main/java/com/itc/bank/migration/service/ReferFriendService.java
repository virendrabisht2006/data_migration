package com.itc.bank.migration.service;

import com.itc.bank.migration.entity.destination.DReferFriend;
import com.itc.bank.migration.entity.source.SReferFriend;
import com.itc.bank.migration.repository.command.ReferfriendRepository;
import com.itc.bank.migration.repository.query.SReferfriendRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
public class ReferFriendService {

    @Autowired
    private SReferfriendRepository sReferfriendRepository;

    @Autowired
    private ReferfriendRepository referfriendRepository;

    private final static Logger logger = Logger.getLogger(ReferFriendService.class);

    public void migrateReferFriend() {
        logger.info("About to migrate table RS_REFER_FRIEND");
        List<SReferFriend> sReferFriends = (List<SReferFriend>) sReferfriendRepository.findAll();
        logger.debug("Query successful for table: RS_REFER_FRIEND and size: {} " + sReferFriends.size());
        saveReferFriend(sReferFriends);
        logger.debug("RS_REFER_FRIEND migrated successfully time: " + new Date());
    }

    @Transactional(propagation = REQUIRED)
    public void saveReferFriend(List<SReferFriend> sReferFriends) {
        sReferFriends.stream().forEach(sReferFriend -> referfriendRepository.save(buildReferFriend(sReferFriend)));
    }

    private DReferFriend buildReferFriend(SReferFriend sReferFriend) {
        return DReferFriend.builder()
                .uId(String.valueOf(sReferFriend.getRefId()))
                .rfId(sReferFriend.getRefId())
                //TODO title, policyHolder, mobile, city is not available in source table
                // phoneNumber is string in source but big int in destination
                // .title(sReferFriend.)
                .email(sReferFriend.getEmail1())
                //.phoneNumber(BigInteger.p(sReferFriend.getPhoneNumber()))
                .referName(sReferFriend.getName())
                .regDate(sReferFriend.getRegDate())
                .build();
    }
}
