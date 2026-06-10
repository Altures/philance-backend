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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Transactional
    public Rating publishReview(Long id_assignment,
                                Long id_author,
                                Long id_subject,
                                Integer review,
                                String comments){

        //1. Se a nota e o comentário não são enviados, retorna vazio
        if ((review == null || review == 0) && (comments == null || comments.trim().isEmpty())) {
            return null;
        }

        //2. Aqui verifica as notas para não ter notas maiores ou menores do permitido
        if (review != null) {
            if (review > 5) {
                review = 5; // Se é enviada uma nota maior do que é permitido, vira 5
            } else if (review < 1) {
                review = 1; // Se é enviada uma nota menor do que é permitido, vira 1
            }
        }

        Assignment assignment = assignmentRepository.findById(id_assignment)
                .orElseThrow(() -> new RuntimeException("Assignment not found!"));
        User author = userRepository.findById(id_author)
                .orElseThrow(() -> new RuntimeException("Author not found!"));
        User subject = userRepository.findById(id_subject)
                .orElseThrow(() -> new RuntimeException("Subject not found!"));

        //3. Se for 'C' (Company), o comentário vira nulo
        String authorComment;

        if (author.getType() == 'C') {
            authorComment = null; // Empresa não pode comentar, vira nulo
        } else {
            authorComment = comments; // Freelancer pode, então mantém o texto
        }

        Rating newRating = new Rating();

        newRating.setAssignment(assignment);
        newRating.setAuthor(author);
        newRating.setSubject(subject);
        newRating.setReview(review);
        newRating.setComments(authorComment);

        return ratingRepository.save(newRating);
    }
}