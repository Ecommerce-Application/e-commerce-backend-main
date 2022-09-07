package com.revature.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddressRequest {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String city;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String country;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String state;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z \\d]*$")
    private String street;

    @NotBlank
    @Pattern(regexp = "^[\\d]+$")
    private String zipCode;
}
