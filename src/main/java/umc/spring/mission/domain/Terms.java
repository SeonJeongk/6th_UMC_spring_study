package umc.spring.mission.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.mission.domain.common.BaseEntity;
import umc.spring.mission.domain.mapping.UserAgree;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String body;

    private Boolean optional;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<UserAgree> userAgreeList = new ArrayList<>();
}