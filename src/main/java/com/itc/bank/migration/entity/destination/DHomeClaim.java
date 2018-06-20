package com.itc.bank.migration.entity.destination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "RS_HomeClaim")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DHomeClaim {

    @Id
    //  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_")
    private int id;

    @Column(name = "claimNature")
    private String claimNature;

    @Column(name = "claimAmt")
    private double claimAmount;

    @Column(name = "policyNo")
    private String policyNo;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "mobileNo")
    private String mobileNo;

    @Column(name = "resNo")
    private String resNo;

    @Column(name = "offNo")
    private String offNo;

    @Column(name = "address")
    private String address;

    @Column(name = "regDate")
    private Date regDate;

    @Column(name = "lossDate")
    private Date lossDate;

    @Column(name = "name")
    private String name;

    @Column(name = "createDate")
    private Date createDate;
}
