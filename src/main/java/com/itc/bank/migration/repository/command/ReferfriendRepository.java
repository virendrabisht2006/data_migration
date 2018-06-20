package com.itc.bank.migration.repository.command;

import com.itc.bank.migration.entity.destination.DReferFriend;
import com.itc.bank.migration.entity.source.SReferFriend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ReferfriendRepository extends CrudRepository<DReferFriend, Integer> {
    void save(List<DReferFriend> dReferFriend);
}
