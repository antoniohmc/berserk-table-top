package com.rpg.berserk_table_top.service.accountPlayer;

import com.rpg.berserk_table_top.exeptions.accountplayer.AccountIdNotFound;
import com.rpg.berserk_table_top.exeptions.accountplayer.ExistingNicknameExeption;
import com.rpg.berserk_table_top.exeptions.accountplayer.IncorrectPasswordExeption;
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

    public void deleteAccount(String accountId) throws AccountIdNotFound {
        AccountPlayer accountPlayer = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountIdNotFound("ID não encontrado"));

        accountRepository.deleteById(accountId);
    }

    public AccountPlayer findAccountByNickname(String nickname) throws NotFoundAccount {
        return accountRepository.findByNickname(nickname)
                .orElseThrow(() -> new NotFoundAccount("Nenhuma conta registrada com esse apelido."));
    }

    public AccountPlayer updateAccount(String nickname, AccountPlayer accountPlayer) throws IncorrectPasswordExeption {
        AccountPlayer existAccount = findAccountByNickname(nickname);

        if (!accountPlayer.getPassword().equals(existAccount.getPassword())) {
            throw new IncorrectPasswordExeption("Senha incorreta!");
        }

        if(!accountPlayer.getNickname().equals(existAccount.getNickname())) {
            checkNicknameAlreadyExisting(accountPlayer);
        }

        AccountPlayer updatedAccount = AccountPlayer.builder()
                .nickname(accountPlayer.getNickname())
                .password(accountPlayer.getPassword())
                .build();

        return accountRepository.save(updatedAccount);
    }

    private void checkNicknameAlreadyExisting(AccountPlayer account) throws ExistingNicknameExeption {
        Optional<AccountPlayer> accountAlreadyExist = accountRepository.findByNickname(account.getNickname());

        if (accountAlreadyExist.isPresent() && !accountAlreadyExist.get().getId().equals(account.getId())) {
            throw new ExistingNicknameExeption("Apelido de usuario ja esta em uso.");
        }
    }
}
