package board.service;

import board.model.dto.PostDto;
import board.model.entity.PostEntity;
import board.model.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public boolean save(PostDto postDto) {
        PostEntity postEntity = boardRepository.save(postDto.toEntity());
        return postEntity.getNo() > 0;
    }

    public List<PostDto> getList() {
        List<PostEntity> postEntityList = boardRepository.findAll();
        return postEntityList
                .stream()
                .map(PostEntity::toDto)
                .toList();
    }

    public PostDto get(int no) {
        Optional<PostEntity> postEntity = boardRepository.findById(no);

        return postEntity.map(PostEntity::toDto).orElse(null);
    }
}
