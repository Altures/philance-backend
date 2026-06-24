package br.com.philance.backend.controller;

import br.com.philance.backend.DTO.request.address.NewAddressDTO;
import br.com.philance.backend.DTO.response.general.MessageDTO;
import br.com.philance.backend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("/add-address")
    public MessageDTO newAddress(@RequestBody NewAddressDTO dto){
        return addressService.registerAddress(dto.zip_code(), dto.street(), dto.number(), dto.complement(), dto.neighborhood(), dto.city(), dto.state(), dto.id_user());
    }

}
