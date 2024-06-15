package com.farmachinerental.platform.u202212721.inventories.domain.model.aggregates;

import com.farmachinerental.platform.u202212721.inventories.domain.model.commands.CreateToolCommand;
import com.farmachinerental.platform.u202212721.inventories.domain.model.entities.Category;
import com.farmachinerental.platform.u202212721.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * Tool aggregate root
 * <p>
 *     Represents a tool aggregate root in inventory bounded context
 * </p>
 * @author  U20221721 Mathias Jave Diaz
 * @version 1.0
 */
@Entity
@Getter
public class Tool extends AuditableAbstractAggregateRoot<Tool> {

    @NotBlank
    @Column(nullable = false, length = 60)
    @Size(max = 60)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 300)
    @Size(max = 300)
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String referenceImageUrl;

    @Column(nullable = false)
    private Double rentalPrice;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Tool(){

    }

    public Tool(CreateToolCommand command, Category category) {
        this.name = command.name();
        this.description = command.description();
        this.referenceImageUrl = command.referenceImageUrl();
        this.rentalPrice = command.rentalPrice();
        this.category = category;

    }
}
