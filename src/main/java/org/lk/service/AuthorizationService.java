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

    public Boolean checkAuthorization(Integer id, String login, String password) {
        Optional<AuthorizationEntity> optional = jpaUserAuthorizationRepository.findById(id);
        return optional.get().getLogin().equals(login) && passwordEncoder.matches(password, optional.get().getPassword());
    }

    public AuthorizationDto convertToDto(Optional<AuthorizationEntity> post) {
        AuthorizationDto postDto = modelMapper.map(post.get(), AuthorizationDto.class);
        return postDto;
    }
}
