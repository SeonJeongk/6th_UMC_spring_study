package umc.spring.mission.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.mission.domain.common.BaseEntity;
import umc.spring.mission.domain.mapping.FoodLike;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String name;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<FoodLike> foodLikeList = new ArrayList<>();
}