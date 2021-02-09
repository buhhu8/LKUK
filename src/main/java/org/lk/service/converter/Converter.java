package org.lk.service.converter;

/**
 * @param <E> entity class
 * @param <D> dto class
 */
public interface Converter<E, D> {

    E toEntity(D dto);

    D toDto(E entity);

}
