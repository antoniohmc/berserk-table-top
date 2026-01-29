package com.rpg.berserk_table_top.service.accountPlayer;

import com.rpg.berserk_table_top.exeptions.accountplayer.ExistingNicknameExeption;
import com.rpg.berserk_table_top.exeptions.accountplayer.NotFoundAccount;
import com.rpg.berserk_table_top.model.accountplayer.AccountPlayer;
import com.rpg.berserk_table_top.repository.AccountPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountPlayerService {

    private final AccountPlayerRepository accountRepository;

    public AccountPlayer resgisterAccount(AccountPlayer account) throws ExistingNicknameExeption {
        checkNicknameAlreadyExisting(account);
        return accountRepository.save(account);
    }

    public void deleteAccount(Long accountId) throws NotFoundAccount{
        AccountPlayer accountPlayer = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundAccount("ID não encontrado"));
    }

    private void checkNicknameAlreadyExisting(AccountPlayer account) throws ExistingNicknameExeption {
        Optional<AccountPlayer> accountAlreadyExist = accountRepository.findByNickname(account.getNickname());

        if (accountAlreadyExist.isPresent() && !accountAlreadyExist.get().getId().equals(account.getId())) {
            throw new ExistingNicknameExeption("Apelido de usuario ja esta em uso.");
        }

    }
}
