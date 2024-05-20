package umc.spring.mission.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.mission.domain.FoodCategory;
import umc.spring.mission.domain.User;
import umc.spring.mission.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private FoodCategory foodCategory;
}
