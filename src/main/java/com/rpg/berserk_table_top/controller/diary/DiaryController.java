package com.rpg.berserk_table_top.controller.diary;

import com.rpg.berserk_table_top.model.diary.Diary;
import com.rpg.berserk_table_top.repository.DiaryRepository;
import com.rpg.berserk_table_top.service.diary.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryRepository diaryRepository;
    private final DiaryService diaryService;

    @PostMapping("/criar/{accountPlayerId}")
    public ResponseEntity<?> register(@PathVariable String accountPlayerId, @RequestBody DiaryRequest request) {
        diaryService.createDiary(accountPlayerId, request.getName());
        return ResponseEntity.ok("Diario criado com sucesso!");
    }
}
