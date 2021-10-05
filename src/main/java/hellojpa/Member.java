package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "TEAM_ID")
    private Long teamId;
//    @ManyToOne //Many는 Member기준 On은 Team기준
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    //읽기 전용으로 변경(1:다 양방향)
//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    @JoinColumn
    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    @Embedded
    private Period period;

    @Embedded
    private Address homeAddress;

    //디폴트가 지연로딩이다.(lazy)
    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();


//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//    @JoinColumn(name = "MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();
    //위의 값 타입 컬렉션으로 사용하는 것보다 훨씬 더 유리

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name="city",
//                    column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name="street",
//                    column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name="zipcode",
//                    column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;

//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
