package com.shop.entity;


import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="item") //item클래스를 entity로 선언. @Table 어노테이션을 통해 어느 테이블과 매핑될지 지정.
@Getter
@Setter
@ToString
public class Item {
    
    @Id // entity로 선언한 클래스는 반드시 기본키를 가져야함
    @Column(name = "item_id") //컬럼 이름
    @GeneratedValue(strategy = GenerationType.AUTO) //기본키 전략을 AUTO
    private Long id; //상품코드
    
    @Column(nullable = false, length = 50) //항상 값이 있어야 하는 필드는 NOT NULL
    private String itemNm; //상품명
    
    @Column(name = "price", nullable = false)
    private int price; //가격
    
    @Column(nullable = false)
    private int stockNumber; //재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail; //상품 상세 설명
    
    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품 판매 상태
    
    private LocalDateTime regTime; //등록 시간

    private LocalDateTime updateTime;  //수정 시간
}
