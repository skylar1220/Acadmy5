package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.constant.ItemSellStatus;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ItemDto {
	private Long id;
	private String itemNm;
	private int price;
	private int stockNumber; //재고수
	private String itemDetail; 
	private ItemSellStatus itemSellStatus; // 상품판매상태
	private LocalDateTime regTime;
	private LocalDateTime updateTime;
}
