package br.com.philance.backend.service;

import br.com.philance.backend.Repository.AssignmentRepository;
import br.com.philance.backend.Repository.RatingRepository;
import br.com.philance.backend.Repository.UserRepository;
import br.com.philance.backend.model.Assignment;
import br.com.philance.backend.model.Rating;
import br.com.philance.backend.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    private UserRepository userRepository;
    private AssignmentRepository assignmentRepository;

    @Transactional
    public Rating publishReview(Long id_assignment,
                                Long id_author,
                                Long id_subject,
                                int review,
                                String comments){

        Assignment assignment = assignmentRepository.findById(id_assignment)
                .orElseThrow(() -> new RuntimeException("Assignment not found!"));
        User author = userRepository.findById(id_author)
                .orElseThrow(() -> new RuntimeException("Author not found!"));
        User subject = userRepository.findById(id_subject)
                .orElseThrow(() -> new RuntimeException("Subject not found!"));


        Rating newRating = new Rating();
        newRating.setAssignment(assignment);
        newRating.setAuthor(author);
        newRating.setSubject(subject);
        newRating.setReview(review);
        newRating.setComments(comments);

        return ratingRepository.save(newRating);
    }
}