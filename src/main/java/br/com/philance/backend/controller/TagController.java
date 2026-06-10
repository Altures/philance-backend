package br.com.philance.backend.controller;

import br.com.philance.backend.model.Tag;
import br.com.philance.backend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/new-tag")
    public Tag registerTag(@RequestBody Tag newTag){return tagService.registerTag(newTag);}

    @GetMapping("/list-tags")
    public List<Tag> listAllTags(){return tagService.listAll();}
}