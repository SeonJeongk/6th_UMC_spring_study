package umc.spring.mission.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.mission.domain.Review;
import umc.spring.mission.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewReply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(nullable = false)
    private String content;
}
