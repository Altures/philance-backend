package br.com.philance.backend.service;

import br.com.philance.backend.Repository.UserTagRepository;
import br.com.philance.backend.model.Tag;
import br.com.philance.backend.model.User;
import br.com.philance.backend.model.UserTag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTagService {
    @Autowired
    private UserTagRepository userTagRepository;

    /*
    @Transactional
    public UserTag applyTag(User user, Tag tag){
    }*/
}
