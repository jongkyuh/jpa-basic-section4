package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Book;
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

        try {

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("함종규");

            em.persist(book);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();

        }

        // 6. 전체 어플리케이션이 종료하면 엔티티매니저팩토리 닥기
        emf.close();


    }
}