package com.revature.dtos;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class ProductDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DtoId;
    private int prodIdDto;
    private int prodDtoQuantity;


    //Req Args Constructor
    public ProductDTO(int prodIdDto, int prodDtoQuantity) {
        this.prodIdDto = prodIdDto;
        this.prodDtoQuantity = prodDtoQuantity;
    }


    //getters/setters
    public int getProdDtoId() {return DtoId;}

    public void setProdDtoId(int DtoId) {this.DtoId = DtoId;}

    public int getProdId() {return prodIdDto;}

    public void setProdId(int prodIdDto) {this.prodIdDto = prodIdDto;}

    public int getProdDtoQuantity() {return prodDtoQuantity;}

    public void setProdDtoQuantity(int prodDtoQuantity) {this.prodDtoQuantity = prodDtoQuantity;}
}
