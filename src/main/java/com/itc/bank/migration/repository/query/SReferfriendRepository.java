package com.itc.bank.migration.repository.query;

import com.itc.bank.migration.entity.source.SReferFriend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SReferfriendRepository extends CrudRepository<SReferFriend, Integer> {
}
