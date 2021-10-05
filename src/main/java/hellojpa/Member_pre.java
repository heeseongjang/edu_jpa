package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.Date;


//@Getter
//@Setter
//@Entity
//@Table(name="MBR") //매핑할 table의 이름을 적는다.
//@SequenceGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1, allocationSize = 50) //allocationSize는 메모리에 담아두는 sequece갯수?값?
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member_pre {
//    @Id
////    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
////    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //이걸 사용하게 되면 persist시점(영속성)에 db로 바로 날림!(commit전에)
//    private Long id;
//    @Column(name = "name", nullable = false)
//    private String username;
//    private Integer age;
//    @Enumerated(EnumType.STRING)
//    // Ordinal을 하고 난 후 enum순서를 추가하여 변경할 경우 기존 db의 값이 보장이안됨.
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    @Lob
//    private String description;
//
//    @Transient
//    private String temp; // DB와 매핑하지 않은 필드(메모리에서만 사용하겠다)
//
//    public Member_pre() {
//    }
}
