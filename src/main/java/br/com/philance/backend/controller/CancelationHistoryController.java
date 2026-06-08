package br.com.philance.backend.controller;

import br.com.philance.backend.DTO.CancelDTO;
import br.com.philance.backend.model.CancelationHistory;
import br.com.philance.backend.service.CancelationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CancelationHistoryController {

    @Autowired
    private CancelationHistoryService cancelationHistoryService;

    @PostMapping("/cancelations-history")
    public CancelationHistory cancelationHistory(@RequestBody CancelDTO dto){
        return cancelationHistoryService.cancel(dto.id_assignment(), dto.id_user(), dto.reason());
    }
}
