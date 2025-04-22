package board.model.entity;

import board.model.dto.PostDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table (name = "board")
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int no;
    @Column (nullable = false)
    private String subject;
    @Column (nullable = false)
    private String content;

    public PostDto toDto() {
        return PostDto.builder()
                .no(no)
                .subject(subject)
                .content(content)
                .build();
    }
}
