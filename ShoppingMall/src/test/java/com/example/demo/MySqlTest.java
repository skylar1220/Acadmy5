package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.TestPropertySource;

import com.example.demo.constant.ItemSellStatus;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
@SpringBootTest
//@TestPropertySource(locations = "classpath:application.properties")
class MySqlTest {

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	@Order(1)
	@DisplayName("상품저장테스트")
	void createItemTest() {
		for (int i = 0; i < 10; i++) {
			Item item = new Item();
			item.setItemNm("테스트상품 "+i);
			item.setPrice(10000 + Integer.valueOf(i));
			item.setItemDetail("테스트상품설명 "+i);
			item.setStockNumber(100+ Integer.valueOf(i));
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			item.setItemSellStatus(ItemSellStatus.SELL);
			itemRepository.save(item);			
		}
	}
	@Test
	@Order(2)
	@DisplayName("상품명_조회_테스트")
	public void findByItemNmTest() {
		List<Item> itemLists = itemRepository.findByItemNm("테스트상품설명 0");		
		assertNotNull(itemLists);		
		for (Item item : itemLists) {
			System.out.println(item);
		}
	}

	@Test
	@Order(3)
	@DisplayName("상품명 or 상세설명 조회 테스트")
	public void test1(){
		List<Item> itemLists = itemRepository.findByItemNmOrItemDetail("테스트상품설명 1", "test");
		assertNotNull(itemLists);
	}

}








