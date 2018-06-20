package com.itc.bank.migration.entity.source;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="RS_REFER_FRIEND")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SReferFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REF_ID")
    private int refId;

    @Column(name ="NAME")
    private String name;

    @Column(name = "PHONENO")
    private String phoneNumber;

    @Column(name = "EMAILID")
    private String emailId;

    @Column(name = "NAME1")
    private String name1;

    @Column(name ="PHONE1")
    private String phone1;

    @Column(name = "EMAIL1")
    private String email1;

    @Column(name = "NAME2")
    private String name2;

    @Column(name ="PHONE2")
    private String phone2;

    @Column(name = "EMAIL2")
    private String email2;

    @Column(name = "NAME3")
    private String name3;

    @Column(name ="PHONE3")
    private String phone3;

    @Column(name = "EMAIL3")
    private String email3;

    @Column(name="REG_DATE")
    private Date regDate;

}
