package umc.spring.mission.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.mission.domain.common.BaseEntity;
import umc.spring.mission.domain.enums.Gender;
import umc.spring.mission.domain.enums.MemberStatus;
import umc.spring.mission.domain.enums.SocialType;
import umc.spring.mission.domain.mapping.FoodLike;
import umc.spring.mission.domain.mapping.UserAgree;
import umc.spring.mission.domain.mapping.UserMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String pw;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    private LocalDate birthday;

    @Column(nullable = false, length = 80)
    private String address;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false)
    private Integer point = 0;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50)")
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAgree> userAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FoodLike> foodLikeList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();
}
