package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // 엔티티매니저는 프로그램 실행시점에 딱 하나만 생성되어있어야함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {




            tx.commit();
        } catch (Exception e) {
            // 해당 트랜잭션 안에서 하나라도 오류가 나면 전체롤백되게됨
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
