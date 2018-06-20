package com.itc.bank.migration.entity.source;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="RS_DONTCALL")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SDoNotCall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REF_ID")
    private int refId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name ="MOBILE")
    private String mobile;

    @Column(name = "EMAIL")
    private String email;

   // @Column(name = "REG_DATE")
  //  private Date regDate;

    @Column(name = "PHONE_STD")
    private String phoneStd;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MEDIUM")
    private String medium;

}
