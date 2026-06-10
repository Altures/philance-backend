package br.com.philance.backend.DTO.request.tag;
//Used to apply a tag to a user or an assignment
public record ApplyTagDTO(Long idUser,
                          Long idTag) {}