package org.lk.service;

import lombok.AllArgsConstructor;
import org.lk.model.domain.AuthorizationEntity;
import org.lk.model.dto.AuthorizationDto;
import org.lk.repository.jpa.JpaUserAuthorizationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private JpaUserAuthorizationRepository jpaUserAuthorizationRepository;

    public Boolean checkAuthorization(String login, String password) {
        Optional<AuthorizationEntity> optional = jpaUserAuthorizationRepository.findByLogin(login);
        return optional.get().getLogin().equals(login) && passwordEncoder.matches(password, optional.get().getPassword());
    }

    public Integer returnId(String login) {
        return jpaUserAuthorizationRepository.findByLogin(login).get().getId();
    }

    public AuthorizationDto convertToDto(Optional<AuthorizationEntity> post) {
        AuthorizationDto postDto = modelMapper.map(post.get(), AuthorizationDto.class);
        return postDto;
    }

    public AuthorizationEntity convertToEntity(Optional<AuthorizationDto> post) {
        AuthorizationEntity postEntity = modelMapper.map(post.get(), AuthorizationEntity.class);
        return postEntity;
    }

    public AuthorizationDto insertData(Integer id, String login, String password) {
        AuthorizationDto dto = new AuthorizationDto();
        dto.setId(id);
        dto.setLogin(login);
        dto.setPassword(password);
        return dto;
    }
}