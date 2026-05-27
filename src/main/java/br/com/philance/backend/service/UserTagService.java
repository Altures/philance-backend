package br.com.philance.backend.service;

import br.com.philance.backend.Repository.TagRepository;
import br.com.philance.backend.Repository.UserRepository;
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
    private UserRepository userRepository;
    private TagRepository tagRepository;

    @Transactional
    public UserTag applyTag(Long idUser, Long idTag){

        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        Tag tag = tagRepository.findById(idTag)
                .orElseThrow(()-> new RuntimeException("Tag not found!"));

        UserTag newUserTag = new UserTag();
        newUserTag.setId_user(user);
        newUserTag.setId_tag(tag);

        return userTagRepository.save(newUserTag);
    }
}
