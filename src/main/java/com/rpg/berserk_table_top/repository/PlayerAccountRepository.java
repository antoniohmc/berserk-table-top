package com.rpg.berserk_table_top.repository;

import com.rpg.berserk_table_top.model.playeraccount.PlayerAccount;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerAccountRepository {
    Optional<PlayerAccount> findByNickname(String nickname);
}
