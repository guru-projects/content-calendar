package com.guru.content_calendar.repository;

import com.guru.content_calendar.model.Content;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/*
 * This interface declares that ContentRepository extends ListCrudRepository, which provides methods for
 * performing CRUD operations on Content objects identified by an Integer type ID.
    By extending ListCrudRepository, ContentRepository inherits several useful methods,
    such as:
    save(S entity): To save an entity.
    findById(ID id): To find an entity by its ID.
    deleteById(ID id): To delete an entity by its ID.
    findAll(): To retrieve all entities.
    And various other methods for manipulating the data.
    Custom Query Method
 *
 */
public interface ContentRepository extends ListCrudRepository<Content,Integer> {

    List<Content> findAllByContentType(String type);
}
