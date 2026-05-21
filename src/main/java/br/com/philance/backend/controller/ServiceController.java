package br.com.philance.backend.controller;

import br.com.philance.backend.Repository.ServiceRepository;
import br.com.philance.backend.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


@RestController
public class ServiceController {

    private ServiceRepository serviceRepo;

    @PostMapping("/servicos")
    public Service cadastrarServico(@RequestBody Service newService){
        return serviceRepo.save(newService);
    }


}
