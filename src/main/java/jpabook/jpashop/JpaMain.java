package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

public class JpaMain {

    public static void main(String[] args) {
        // 1. 엔티티매니저팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 2. 엔티티 매니저 생성
        EntityManager em = emf.createEntityManager();

        // 3. 트랜잭션 생성
        EntityTransaction tx = em.getTransaction();
        // 4. 트랜잭션 시작
        tx.begin();

        //code.....
        Member member1 = null;
        try {
            member1 = new Member();
            member1.setName("A");
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("B");
            em.persist(member2);

            Order order1 = new Order();
            order1.setMember(member1);
            member1.getOrders().add(order1);
            em.persist(order1);

            Order order2 = new Order();
            order2.setMember(member1);
            member1.getOrders().add(order2);
            em.persist(order2);

            Order order3 = new Order();
            order3.setMember(member1);
            em.persist(order3);

            order3.setMember(member2);
            member2.getOrders().add(order3);


            for (Order order : member1.getOrders()) {
                System.out.println("order = " + order.getId());
            }


            System.out.println("+++++++++++++++++++++++++");
//            em.clear();

            for (Order order : member1.getOrders()) {
                System.out.println("order = " + order);
            }
            System.out.println("++++++++++++++++++++");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();

        }
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction transaction2 = em2.getTransaction();
        transaction2.begin();
        Member findMember = em2.find(Member.class, member1.getId());
        for (Order order : findMember.getOrders()) {
            System.out.println("order = " + order);
        }
        transaction2.commit();
        em2.close();
        // 6. 전체 어플리케이션이 종료하면 엔티티매니저팩토리 닥기
        emf.close();


    }
}