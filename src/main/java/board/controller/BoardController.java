package board.controller;

import board.model.dto.PostDto;
import board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public boolean create(@RequestBody PostDto postDto) {
        System.out.println("BoardController.create");
        System.out.println("postDto = " + postDto);
        return boardService.save(postDto);
    }

    @GetMapping
    public List<PostDto> getList() {
        return boardService.getList();
    }

    @GetMapping ("/view")
    public PostDto get(@RequestParam int no) {
        return boardService.get(no);
    }
}