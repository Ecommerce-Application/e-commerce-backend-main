package com.revature.dtos;

<<<<<<< Updated upstream
=======
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
>>>>>>> Stashed changes
public class ProductDTO {

    private int prodIdDto;
    private int prodDtoQuantity;

    //Constructor
    public ProductDTO() { }
    public ProductDTO(int prodIdDto, int prodDtoQuantity) {
        this.prodIdDto = prodIdDto;
        this.prodDtoQuantity = prodDtoQuantity;
    }
<<<<<<< Updated upstream

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
=======
>>>>>>> Stashed changes
}
