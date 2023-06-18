package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.constant.ItemSellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // pk
	
	@Column(nullable = false,length = 50)
	private String itemNm;  // 상품명
	@Column(nullable = false)
	private int price;
	@Column(nullable = false)
	private int stockNumber; //재고수
	@Lob
	@Column(nullable = false)
	private String itemDetail; 
	
	@Column(nullable = false)
	private ItemSellStatus itemSellStatus; // 상품판매상태	
	@Column(nullable = false)
	private LocalDateTime regTime;
	@Column(nullable = false)
	private LocalDateTime updateTime;
	
}
