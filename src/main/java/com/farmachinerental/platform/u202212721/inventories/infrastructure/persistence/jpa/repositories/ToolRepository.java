package com.farmachinerental.platform.u202212721.inventories.infrastructure.persistence.jpa.repositories;

import com.farmachinerental.platform.u202212721.inventories.domain.model.aggregates.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Tool Repository
 * <p>
 *     This interface is used to manage the Tool aggregate root in the database.
 *      Extends JpaRepository to use the CRUD operations.
 *      JpaRepository<Category, Long> indicates that the entity is Category and the primary key is Long.
 *      The primary key is the unique identifier of the entity.
 *      JpaRepository<Category, Long> provides the basic CRUD operations like save, delete, findById, findAll, etc.
 *      Follow the open closed principle, the interface is open for extension and closed for modification.
 * </p>
 *
 * @author  U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public interface ToolRepository extends JpaRepository<Tool, Long>{

    boolean existsByName (String name);
}
