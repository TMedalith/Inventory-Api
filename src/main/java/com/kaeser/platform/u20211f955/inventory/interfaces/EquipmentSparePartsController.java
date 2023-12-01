package com.kaeser.platform.u20211f955.inventory.interfaces;

import com.kaeser.platform.u20211f955.inventory.domain.model.commands.AddSparePartCommand;
import com.kaeser.platform.u20211f955.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetEquipmentByIdQuery;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetSparePartByIdQuery;
import com.kaeser.platform.u20211f955.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.u20211f955.inventory.domain.services.SparePartCommandService;
import com.kaeser.platform.u20211f955.inventory.domain.services.SparePartQueryService;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources.CreateSparePartResource;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources.SparePartResource;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.transform.CreateSparePartCommandFromResourceAssembler;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.transform.SparePartResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/equipments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Spare Parts", description = "Spare Parts Management Endpoints")
public class EquipmentSparePartsController {
    private final SparePartQueryService sparePartQueryService;
    private final SparePartCommandService sparePartCommandService;
    private final EquipmentQueryService equipmentQueryService;

    public EquipmentSparePartsController(SparePartQueryService sparePartQueryService, SparePartCommandService sparePartCommandService, EquipmentQueryService equipmentQueryService) {
        this.sparePartQueryService = sparePartQueryService;
        this.sparePartCommandService = sparePartCommandService;
        this.equipmentQueryService = equipmentQueryService;
    }



    @PostMapping("/{equipmentId}/spare-parts")
    public ResponseEntity<SparePartResource> addSparePartToEquipment(@PathVariable Long equipmentId, @RequestBody CreateSparePartResource resource) {

        var addSparePartCommand = new AddSparePartCommand(resource.supplierId(), resource.model(), resource.supplierProvidedSerialNumber(), equipmentId);
        Long sparePartId = sparePartCommandService.Handle(addSparePartCommand);

        if (sparePartId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getSparePartByIdQuery = new GetSparePartByIdQuery(sparePartId);
        var sparePart = sparePartQueryService.handle(getSparePartByIdQuery);
        if (sparePart.isEmpty()) return ResponseEntity.badRequest().build();
        var sparePartResource = SparePartResourceFromEntityAssembler.toResourceFromEntity(sparePart.get());
        return new ResponseEntity<>(sparePartResource, HttpStatus.CREATED);
    }

}
