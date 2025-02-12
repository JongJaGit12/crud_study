package com.example.reactboard;

import com.example.reactboard.db.BoardEntity;
import com.example.reactboard.db.BoardMapper;
import com.example.reactboard.dto.BoardSaveDto;
import com.example.reactboard.util.Header;
import com.example.reactboard.util.Search;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class BoardController {


    private final BoardService boardService;



    @GetMapping("/board")
    Header<List<BoardEntity>> getBoardList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Search search) {
        return boardService.getBoardList(page, size, search);
    }
    
    @GetMapping("/board/{idx}")
    Header<BoardEntity> createBoardOne(@PathVariable Long idx) {
        log.info("idx###" + idx);
        return boardService.getBoardOne(idx);
    }

    @PostMapping("/board")
    Header<BoardEntity> createBoard(@RequestBody BoardSaveDto boardSaveDto) {
        return boardService.inserBoard(boardSaveDto);
    }

    @PatchMapping("/board")
    Header<BoardEntity> updateBoard(@RequestBody BoardSaveDto boardSaveDto) {
        return boardService.updateBoard(boardSaveDto);
    }

    @DeleteMapping("/board/{idx}")
    Header<BoardEntity> deleteBoard(@PathVariable Long idx) {
        return boardService.deleteBoard(idx);
    }


}
