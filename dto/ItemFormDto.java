package com.top.dto;

import com.top.constant.ItemSellStatus;
import com.top.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemFormDto {
    private Long no; // 1101 성아 id -> no 수정

    private Long category;

    @NotBlank(message = "상품명을 입력하세요")
    private String itemNm;

    @NotNull(message = "가격을 입력하세요")
    private Integer price;

    @NotBlank(message = "이름을 입력하세요")
    private String itemDetail;

    @NotNull(message = "재고를 입력하세요")
    private Integer stockNumber;
    private ItemSellStatus itemSellStatus;
    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();
    private List<Long> itemImgIds = new ArrayList<>();

    private Double avg; // 1028 성아 추가 // 평균 평점
    private Integer reviewCnt; // 1028 성아 추가 // 리뷰 개수

    private static ModelMapper modelMapper = new ModelMapper();

    public Item createItem(){
        return modelMapper.map(this, Item.class);
    }

    public static ItemFormDto of(Item item){
        return modelMapper.map(item,ItemFormDto.class);
    }

}
