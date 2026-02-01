package com.rpg.berserk_table_top.controller.accountplayer;

import com.rpg.berserk_table_top.model.accountplayer.AccountPlayer;
import com.rpg.berserk_table_top.service.accountPlayer.AccountPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountPlayerController {

    private final AccountPlayerService accountService;

    @PostMapping("/cadastrar")
    public AccountPlayerResponse register(@RequestBody AccountPlayerRequest request) {
        AccountPlayer account = AccountPlayerMapper.mapToEntity(request);
        AccountPlayer save = accountService.resgisterAccount(account);
        return AccountPlayerMapper.mapToResponse(save);
    }

    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<AccountPlayerResponse> getAccountByNickname (@PathVariable String nickname) {
        AccountPlayer account = accountService.findAccountByNickname(nickname);
        return ResponseEntity.ok(AccountPlayerMapper.mapToResponse(account));
    }

    @GetMapping("/findAll")
    public List<AccountPlayerResponse> getAllAccounts() {
        return accountService.getAccounts()
                .stream()
                .map(AccountPlayerMapper::mapToResponse)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Conta deletada com Sucesso");
    }
}
