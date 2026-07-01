package br.com.philance.backend.service;

import br.com.philance.backend.DTO.response.general.MessageDTO;
import br.com.philance.backend.model.Address;
import br.com.philance.backend.model.User;
import br.com.philance.backend.repository.AddressRepository;
import br.com.philance.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    public MessageDTO registerAddress(String zip_code, String street, String number, String complement, String neighborhood, String city, String state, String id_user){

        User user = userRepository.findById(id_user)
                .orElseThrow(()-> new RuntimeException("User not found"));

        Address newAddress = new Address();

        newAddress.setZipCode(zip_code);
        newAddress.setStreet(street);
        newAddress.setNumber(number);
        newAddress.setComplement(complement);
        newAddress.setNeighborhood(neighborhood);
        newAddress.setCity(city);
        newAddress.setState(state);

        if (user.getAddress()!=null && user.getAddress().equals(newAddress)) {
            return  new MessageDTO("You already have this address saved","Same address as older one");
        }
        if (!addressRepository.existsByZipCodeAndStreetAndNumberAndComplementAndNeighborhoodAndCityAndState(zip_code, street, number, complement, neighborhood, city, state)){
            addressRepository.save(newAddress);
        }
            user.setAddress(newAddress);
            userRepository.save(user);
            return new MessageDTO("Address added successfully","Address already registered, just applied");
        }
}
