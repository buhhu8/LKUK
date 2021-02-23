package org.lk.service.validation;

import org.lk.exception.ValidationException;
import org.lk.model.dto.RegistrationDto;

// Базовый интерфейс для всех DTO
// Реализация этого интерфейса - реализация валидации конкрентого DTO

public interface Validator<T> {

    void validate(T obj);

    default void requireNotBlank(String value) {
        if (value == null || value.trim().isEmpty()) {
           throw new ValidationException("Строка не может быть пустой");
        }

    }

}
