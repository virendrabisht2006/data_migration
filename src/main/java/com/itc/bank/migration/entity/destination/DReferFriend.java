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
@Table(name = "rs_referfriend")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DReferFriend {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid_")
    private String uId;

    @Column(name = "rfId")
    private int rfId;

    @Column(name = "title")
    private String title;

    @Column(name = "isPolicyHolder")
    private int policyHolder;

    @Column(name = "productFor")
    private String productFor;

    @Column(name = "refererName")
    private String referName;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private int phoneNumber;

    @Column(name = "mobile")
    private int mobile;

    @Column(name = "city")
    private String city;

    @Column(name = "regDate")
    private Date regDate;

}
