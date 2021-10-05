package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);

//            em.persist(team);

//            Movie movie = new Movie();
//            movie.setDirector("aaa");
//            movie.setActor("bbb");
//            movie.setName("바람과 함께 사라지다.");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);

//            Member member = new Member();
//            member.setCreateBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("hello");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member m = em.find(Member.class, member.getId());
//
//            System.out.println("m = " + m.getTeam().getClass());
//            System.out.println("-------");
//            m.getTeam().getName();
//            System.out.println("-------");
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.id = " + findMember.getId());
//            printMember(findMember);
//            printMemberAndTeam(findMember);
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember = " + findMember.getClass());
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getUsername());

//            Child child1 = new Child();
//            Child child2 = new Child();
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
////            em.persist(child1);
////            em.persist(child2);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);

//            Address address = new Address("city", "street", "1000");
//            Member member = new Member();
//            member.setUsername("hello1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setUsername("hello2");
//            member2.setHomeAddress(address);
//            em.persist(member2);
//
//            member.getHomeAddress().setCity("newCity");

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street1", "zipcode"));

            member.getFavoriteFoods().add("chicken");
            member.getFavoriteFoods().add("pizza");

            member.getAddressHistory().add(new AddressEntity("old1", "street1", "zipcode"));
            member.getAddressHistory().add(new AddressEntity("old2", "street1", "zipcode"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("++++++++++ START +++++++");
            //컬렉션들은 다 지연로딩(Address는 같이 불러옴 속성이라)
            Member findMember = em.find(Member.class, member.getId());
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favorite food = " + favoriteFood);
//            }

            Address oldAddress = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", oldAddress.getStreet(), oldAddress.getZipcode()));

            findMember.getFavoriteFoods().remove("chicken");
            findMember.getFavoriteFoods().add("hansik");

            System.out.println("++++++++++ ADDRESS +++++++");
            findMember.getAddressHistory().remove(new AddressEntity("old1", "street1", "zipcode"));
            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street1", "zipcode"));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.clear();
        }


//        try {
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
////            member.changeTeam(team);
//            em.persist(member);
//
//            team.addMember(member);
//
//            //team.getMembers().add(member);
//            // 양방향일때 mappedby에 설정을 하지 않게 되면 1차캐시에 들어가 있지 않기 때문에
//            // members를 조회할 경우 나오지 않는다.
//            // flush를 하게 되면 db에 들어가고 clear를 하게 되면 db를 select해와서 보이겟는데.
//            // 이러한 문제 점때문에 양쪽에 값을 셋팅하는 게 낫다.
//            // changeTeam에 add를 하기 때문에 주석처리
//
////            em.flush();
////            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
////            System.out.println(findTeam.getId());
////            System.out.println(findTeam.getName());
//            for (Member memb : findTeam.getMembers()) {
//                System.out.println("member : " + memb.getUsername());
//            }
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.clear();
//        }

//        try {
        //code
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("helloA");
//            //위의 코드까지는 비영속 상태이다.
//            em.persist(member); //persist를 하게 되면 영속 상태가 된다.
//            em.detach(member); //영속성 컨텍스트 삭제

        //조회를 하는데 select문이 안나갔다. 이유는 1차캐시에서 조회하기때문에.
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println("영속 엔티티의 동일성 보장 : " + (findMember1==findMember2));

//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//
//            findMember.setName("helloJPA");

//            em.remove(findMember);

//            List<Member> result =
//                    em.createQuery("select m from Member as m", Member.class)
//                            .setFirstResult(5)
//                            .setMaxResults(8)
//                            .getResultList();
//            for (Member member : result){
//                System.out.println("member.name  : " + member.getName());
//            }
//
//
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("==========");

//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZ"); //더티체킹(스냅샷이랑 비교해서 차이점이 있으면 update)

//            em.remove(member);

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush(); // DB에 insert가 즉시 나감
//            System.out.println("============");

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAA");
//
//            em.detach(member); //영속성 컨텍스트에서 관리하지 않겟다고 정의 -> 준영속 상태
//            em.clear();//영속성 컨텍스트에 있는 모든 것을 다 지움!

//            Member member = new Member();
//            member.setId(4L);
//            member.setUsername("member4");
//            member.setRoleType(RoleType.ADMIN);
//
//            em.persist(member);

//            //영속성 컨텍스트에 있는 내용이 DB로 넘어간다
//            tx.commit();
        //-------------위의 예제까지는 Member_pre의 예제이다.
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.clear();
//        }

        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String usrname = member.getUsername();
        Team team = member.getTeam();
    }
}
