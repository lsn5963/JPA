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
        try{
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
           Member member = new Member();
           member.setUsername("user1");
           member.setCreateBy("kim");
           member.setCreatedDate(LocalDateTime.now());

           em.persist(member);

           em.flush();
           em.clear();

//            Movie Findmovie = em.find(Movie.class, movie.getId());
//            System.out.println("Findmovie = " + Findmovie);


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
