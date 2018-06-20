package com.itc.bank.migration.repository.command;

import com.itc.bank.migration.entity.destination.DHomeClaim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HomeClaimRepository extends CrudRepository<DHomeClaim, Integer> {
}
