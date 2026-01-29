package com.rpg.berserk_table_top.repository;

import com.rpg.berserk_table_top.model.accountplayer.AccountPlayer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountPlayerRepository extends MongoRepository<AccountPlayer,Long> {

    Optional<AccountPlayer> findByNickname(String nickname);

    Optional<AccountPlayer> findById(Long id);
}
