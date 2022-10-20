package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setFavoriteFoods();

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//            Long findTeamId = findMember.getTeamId();
//
//            Team findTeam = em.find(Team.class, findTeamId);    //연관관계가 없어서 이게 너무 귀찮고 매핑관계가 없기 때문에 객체지향스럽지 않음
            // 저장
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team teamB = new Team();
//            teamB.setName("teamA");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setTeam(teamB);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setTeam(teamB);
//            em.persist(member2);  //즉시로딩 예시이다. member를 가져올 쿼리한번 팀 가져올때 teamA쿼리 1번 teamB쿼리 1번 보내게 된다. 너무 비효율적이다.
            //해결법 지연로딩, fetch조인(lazy여도 한번에 다 가져오게 하는 것)(select m from Member m join fetch m.team", Member.class), anotation,

            em.flush();
            em.clear();

//            Movie Findmovie = em.find(Movie.class, movie.getId());
//            System.out.println("Findmovie = " + Findmovie);
            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
