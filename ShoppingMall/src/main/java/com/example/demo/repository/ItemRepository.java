package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Item;
/* 스프링 부트에서는 DAO(Data Access Object) 역활을 하는 객체가 Repository 이다
 * 기본 제공 메소드
 * save
 * delete
 * count
 * findAll
 */
import java.util.List;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

public interface ItemRepository extends JpaRepository<Item, Long> {
	// find + (entity 이름 )+ By + 변수 이름
	List<Item> findByItemNm(String itemNm);
	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
	List<Item> findByPriceLessThan(int price);
	List<Item> findByPriceLessThanOrderByPriceDesc(int price); 		// Desc 추가: 내림차순
	
	@Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

}
