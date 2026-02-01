package com.rpg.berserk_table_top.service.diary;

import com.rpg.berserk_table_top.exceptions.accountplayer.AccountIdNotFound;
import com.rpg.berserk_table_top.exceptions.diary.DiaryAlreadyExisting;
import com.rpg.berserk_table_top.exceptions.diary.NotFoundDiary;
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
    private final CreatureNotesService creatureNotesService;

    public void createDiary(String accountId, String diaryName) {
        AccountPlayer account = accountRepository.findById(accountId).orElseThrow(() -> new AccountIdNotFound("Conta não Encontrada"));

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

    public void deleteDiary(String diaryId) throws NotFoundDiary {
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> new NotFoundDiary("Diario nao encontrado"));

        if (diary.getCreatureNotesId() != null) {
            for (String creatureNoteId : diary.getCreatureNotesId()) {
                creatureNotesService.deleteCreatureNote(creatureNoteId);
            }
        }
        diaryRepository.deleteById(diaryId);
    }
}
