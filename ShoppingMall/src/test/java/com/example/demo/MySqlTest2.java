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
class MySqlTest2 {

	@Autowired
	ItemRepository ir;
	
	@Test
	void test() {
		List<Item> itemLists =  ir.findByItemDetail("테스트상품설명3");
		assertNotNull(itemLists);
		for (Item item : itemLists) {
			System.out.println("------\n"+ item);
		}
	}

}






