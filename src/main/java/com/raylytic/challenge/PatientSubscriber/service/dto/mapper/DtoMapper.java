package com.raylytic.challenge.PatientSubscriber.service.dto.mapper;

import java.util.List;

/**
 * Interface for a generic dto to dao mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - DAO type parameter.
 */

public interface DtoMapper<D, E> {
    E toDao(D dto);

    D toDto(E entity);

    List<E> toDao(List<D> dtoList);

    List<D> toDto(List<E> entityList);

}
