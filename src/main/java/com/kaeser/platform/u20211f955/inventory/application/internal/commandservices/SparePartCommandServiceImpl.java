package com.kaeser.platform.u20211f955.inventory.application.internal.commandservices;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.SparePart;
import com.kaeser.platform.u20211f955.inventory.domain.model.commands.AddSparePartCommand;
import com.kaeser.platform.u20211f955.inventory.domain.services.SparePartCommandService;
import com.kaeser.platform.u20211f955.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import com.kaeser.platform.u20211f955.inventory.infrastructure.persistence.jpa.repositories.SparePartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SparePartCommandServiceImpl implements SparePartCommandService {

    private final SparePartRepository sparePartRepository;
    private final EquipmentRepository equipmentRepository;

    public SparePartCommandServiceImpl(SparePartRepository sparePartRepository, EquipmentRepository equipmentRepository) {
        this.sparePartRepository = sparePartRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Long Handle(AddSparePartCommand command) {

        var equipment = equipmentRepository.findById(command.equipmentId())
                .orElseThrow(() -> new RuntimeException("Equipment not found with id: " + command.equipmentId()));

        if (equipment == null) {
            throw new RuntimeException("SparePart's equipmentId does not match the specified Equipment.");

        }

        var existingSparePartBySupplierId = sparePartRepository.findBySupplierId(command.supplierId());
        var existingSparePartByModel = sparePartRepository.findByModel(command.model());
        var existingSparePartBySupplierProvidedSerialNumber = sparePartRepository.findBySupplierProvidedSerialNumber(command.supplierProvidedSerialNumber());

        if (existingSparePartBySupplierId.isPresent() && existingSparePartBySupplierId.get().getEquipment() != null
                || existingSparePartByModel.isPresent() && existingSparePartByModel.get().getEquipment() != null
                || existingSparePartBySupplierProvidedSerialNumber.isPresent() && existingSparePartBySupplierProvidedSerialNumber.get().getEquipment() != null) {
            throw new RuntimeException("SparePart already exists with the same supplierId, model, or supplierProvidedSerialNumber.");
        }

        var sparePart = new SparePart(command.supplierId(), command.model(), command.supplierProvidedSerialNumber());
        sparePart.updateEquipment(equipment);
         sparePartRepository.save(sparePart);
         return sparePart.getId();
         
    }
}
