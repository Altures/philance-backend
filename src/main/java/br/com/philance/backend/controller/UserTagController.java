package br.com.philance.backend.controller;

import br.com.philance.backend.DTO.ApplyTagDTO;
import br.com.philance.backend.model.Tag;
import br.com.philance.backend.model.User;
import br.com.philance.backend.model.UserTag;
import br.com.philance.backend.service.UserTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTagController {

    @Autowired
    private UserTagService userTagService;

    @PostMapping("/apply-tag")
    public UserTag applyTag(@RequestBody ApplyTagDTO dto) { return userTagService.applyTag(dto.idUser(),dto.idTag());}
}