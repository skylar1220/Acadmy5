package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
@SpringBootTest
class MySqltest2 {

	@Autowired
	ItemRepository ir;
	
//	@PersistenceContext
//	EntityManager entityManager;
	
//	@Test
//	@DisplayName("Querydsl 조회 테스트1")
//	public void queryDslTest() {
//		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
//	}
	
	
	@Test
	void test() {
		List<Item> itemlists = ir.findByItemDetail("테스트상품설명 0");
		assertNotNull(itemlists);				
	}

}
