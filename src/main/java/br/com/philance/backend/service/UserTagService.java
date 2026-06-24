package br.com.philance.backend.service;

import br.com.philance.backend.repository.TagRepository;
import br.com.philance.backend.repository.UserRepository;
import br.com.philance.backend.repository.UserTagRepository;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    public UserTag applyTag(String idUser, String idTag){

        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        Tag tag = tagRepository.findById(idTag)
                .orElseThrow(()-> new RuntimeException("Tag not found!"));

        UserTag newUserTag = new UserTag();

        newUserTag.setUser(user);
        newUserTag.setTag(tag);

        return userTagRepository.save(newUserTag);
    }
}
