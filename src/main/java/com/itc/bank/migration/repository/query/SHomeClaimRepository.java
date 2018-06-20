package com.itc.bank.migration.repository.query;

import com.itc.bank.migration.entity.source.SHomeClaim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SHomeClaimRepository extends CrudRepository<SHomeClaim, Integer> {
}
