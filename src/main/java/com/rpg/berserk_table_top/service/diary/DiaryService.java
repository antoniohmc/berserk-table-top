package com.rpg.berserk_table_top.service.diary;

import com.rpg.berserk_table_top.exeptions.accountplayer.AccountIdNotFound;
import com.rpg.berserk_table_top.exeptions.diary.DiaryAlreadyExisting;
import com.rpg.berserk_table_top.model.accountplayer.AccountPlayer;
import com.rpg.berserk_table_top.model.diary.Diary;
import com.rpg.berserk_table_top.repository.AccountPlayerRepository;
import com.rpg.berserk_table_top.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final AccountPlayerRepository accountRepository;

    public void createDiary(String accountId, String diaryName) {
        AccountPlayer account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountIdNotFound("Conta não Encontrada"));

        if (account.getDiaryId() != null) {
            throw new DiaryAlreadyExisting("Essa conta ja possui um diário");
        }

        Diary diary = Diary.builder()
                .name(diaryName)
                .accountPlayerId(accountId)
                .build();

        Diary saved = diaryRepository.save(diary);

        account.setDiaryId(saved.getId());
        accountRepository.save(account);
    }
}
