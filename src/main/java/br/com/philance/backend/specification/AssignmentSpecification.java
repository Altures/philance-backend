package br.com.philance.backend.specification;

import br.com.philance.backend.DTO.request.assignment.FilterDTO;
import br.com.philance.backend.model.Assignment;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public class AssignmentSpecification {

    public static Specification<Assignment> filtered(FilterDTO filters){
        return ((root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.equal(root.get("status"),"Pending"));

            if (filters == null){
                return criteriaBuilder.and(new Predicate[0]);
            }

            //Checagem e adição de filtros à lista

            if (filters.address() != null && !filters.address().isBlank()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("address")),
                        "%" + filters.address().toLowerCase() + "%"
                ));
            }

            if (filters.payment() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("payment"),filters.payment()));
            }

            if (filters.min_age() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("min_age"),filters.min_age()));
            }
            if (filters.startHour() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startHour"),filters.startHour()));
            }
            if (filters.id_tag() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("id_tag"),filters.id_tag()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
