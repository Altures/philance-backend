package br.com.philance.backend.service;

import br.com.philance.backend.repository.TagRepository;
import br.com.philance.backend.model.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    public Tag registerTag(Tag newTag){

        return tagRepository.save(newTag);
    }

    @Transactional
    public List<Tag> listAll(){
        return tagRepository.findAll();
    }
}
