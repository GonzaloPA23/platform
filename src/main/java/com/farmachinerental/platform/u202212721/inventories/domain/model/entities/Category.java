package com.farmachinerental.platform.u202212721.inventories.domain.model.entities;


import com.farmachinerental.platform.u202212721.inventories.domain.model.valueobjects.CategoryTypes;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Category entity
 * <p>
 *     Represents a category entity in inventory bounded context
 * </p>
 * @author  U20221721 Mathias Jave Diaz
 * @version 1.0
 */
@Entity
@Getter
@Table(name = "category_types")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryTypes type;

    public Category(){

    }

    /**
     * Constructor with parameters
     * <p>
     *     Creates a new category with the given type
     * </p>
     * @param type the type of the category
     * @author U20221721 Mathias Jave Diaz
     */

    public Category(CategoryTypes type){
        this.type = type;
    }
}
