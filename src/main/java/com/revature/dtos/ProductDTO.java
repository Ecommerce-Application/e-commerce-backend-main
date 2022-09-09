package com.revature.dtos;

public class ProductDTO {

    private int prodIdDto;
    private int prodDtoQuantity;

    //Constructor
    public ProductDTO() { }
    public ProductDTO(int prodIdDto, int prodDtoQuantity) {
        this.prodIdDto = prodIdDto;
        this.prodDtoQuantity = prodDtoQuantity;
    }

    //Getter n Setter


    public int getProdIdDto() {
        return prodIdDto;
    }

    public void setProdIdDto(int prodIdDto) {
        this.prodIdDto = prodIdDto;
    }

    public int getProdDtoQuantity() {
        return prodDtoQuantity;
    }

    public void setProdDtoQuantity(int prodDtoQuantity) {
        this.prodDtoQuantity = prodDtoQuantity;
    }
}
