package com.example.traning.Model;

import java.util.List;

public interface MapperCommon<E, D> {
    D toEntityDTO(E e);
    E toDTOEntity(D d);
    List<D> toListEntityListDTO(List<E> e);
    List<E> toListDTOListEntity(List<D> d);
}
