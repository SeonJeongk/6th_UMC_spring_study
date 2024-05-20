package umc.spring.mission.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.mission.domain.common.BaseEntity;
import umc.spring.mission.domain.mapping.UserMission;

import java.time.LocalDate;
import java.util.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false)
    private Integer reward = 100;

    @Column(nullable = false)
    private LocalDate deadline;

    @Column(nullable = false)
    private String missionSpec;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();
}