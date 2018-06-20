package com.itc.bank.migration.entity.source;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RS_HOME_CLAIM")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SHomeClaim {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "LOSS_DATE")
    private String lossDate;

    @Column(name = "CLAIM_NATURE")
    private String claimNature;

    @Column(name = "CLAIM_AMT")
    private float claimAmount;

    @Column(name = "POLICY_NO")
    private String policyNumber;

    @Column(name = "EMAILID")
    private String emailId;

    @Column(name = "MOBILENO")
    private String mobileNumber;

    @Column(name = "RESNO")
    private String resNo;

    @Column(name = "OFFNO")
    private String offNo;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "REG_DATE")
    private Date regDate;
}
