package com.farmachinerental.platform.u202212721.inventories.interfaces.rest;

import com.farmachinerental.platform.u202212721.inventories.domain.services.ToolCommandService;
import com.farmachinerental.platform.u202212721.inventories.interfaces.rest.resources.CreateToolResource;
import com.farmachinerental.platform.u202212721.inventories.interfaces.rest.transform.CreateToolCommandFromResourceAssembler;
import com.farmachinerental.platform.u202212721.inventories.interfaces.rest.transform.ToolResourceFromEntityAssembler;
import com.farmachinerental.platform.u202212721.shared.interfaces.rest.resources.MessageResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tool Controller
 * <p>
 *     This class represents the REST controller for the Tool entity.
 *     It is responsible for handling the incoming HTTP requests related to the Tool entity.
 * </p>
 * @author  U202212711 Mathias Jave Diaz
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Equipment", description = "Equipment Controller")
public class ToolController {

    private final ToolCommandService toolCommandService;

    public ToolController(ToolCommandService toolCommandService) {
        this.toolCommandService = toolCommandService;
    }

    /**
     * Create a new Tool resource
     * <p>
     *     This method is responsible for handling the incoming HTTP POST requests to create a new Tool resource.
     *     It receives a CreateToolResource object as a parameter and returns a ResponseEntity object.
     * </p>
     * @param createToolResource The CreateToolResource object that contains the information to create the new Tool resource.
     * @return A ResponseEntity object with the created Tool resource or an error message.
     * @author U202212721 Mathias Jave Diaz
     */

    @PostMapping
    public ResponseEntity<?> createTool(@RequestBody CreateToolResource createToolResource) {
        try{
            var command = CreateToolCommandFromResourceAssembler.toCommandFromResource(createToolResource);
            var tool = toolCommandService.handle(command);
            var toolResource = ToolResourceFromEntityAssembler.toResourceFromEntity(tool.get());
            return new ResponseEntity<>(toolResource, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResource(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
