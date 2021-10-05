package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;
    //    @OneToMany(mappedBy = "team") //Member의 team 필드와 관련되어있다.
//    1:다 예제
//    @OneToMany
//    @JoinColumn(name = "TEAM_ID")
//    private List<Member> members = new ArrayList<>();

//    public void addMember(Member member){
//        member.setTeam(this);
//        members.add(member);
//    }
}
