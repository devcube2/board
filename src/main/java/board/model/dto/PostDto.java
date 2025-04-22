package board.model.dto;

import board.model.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class PostDto {
    private int no;
    private String subject;
    private String content;

    public PostEntity toEntity() {
        return PostEntity.builder()
                .no(no)
                .subject(subject)
                .content(content)
                .build();
    }
}
