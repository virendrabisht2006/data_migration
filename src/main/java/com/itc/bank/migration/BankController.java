package com.itc.bank.migration;

import com.itc.bank.migration.service.HomeClaimService;
import com.itc.bank.migration.service.ReferFriendService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping(value = "/v1")
public class BankController {

    private final static Logger logger = Logger.getLogger(BankController.class);

    @Autowired
    private ReferFriendService referFriendService;

    @Autowired
    private HomeClaimService homeClaimService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> welcome(UriComponentsBuilder ucBuilder) {
        logger.info("Welcome to data loader application");
        String response = "Welcome to  data loader application is up and running+\n\n\n";
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/migrate", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> migrate(UriComponentsBuilder ucBuilder) {
        logger.info("About to migrate data from source to destination");
        String response = null;
        try {
            //  referFriendService.migrateReferFriend();
            homeClaimService.migrateHomeClaim();
            response = "Migration completed successfully +\n\n\n";
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = "There is error in operation: " + e.getMessage();
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
