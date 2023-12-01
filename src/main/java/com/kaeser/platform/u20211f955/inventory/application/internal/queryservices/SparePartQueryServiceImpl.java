package com.kaeser.platform.u20211f955.inventory.application.internal.queryservices;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.SparePart;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetSparePartByIdQuery;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetSparePartByMaterialSerialNumberQuery;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetSparePartsByEquipmentIdQuery;
import com.kaeser.platform.u20211f955.inventory.domain.services.SparePartQueryService;
import com.kaeser.platform.u20211f955.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import com.kaeser.platform.u20211f955.inventory.infrastructure.persistence.jpa.repositories.SparePartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SparePartQueryServiceImpl implements SparePartQueryService {

    private final SparePartRepository sparePartRepository;

    public SparePartQueryServiceImpl(SparePartRepository sparePartRepository) {
        this.sparePartRepository = sparePartRepository;
    }
    @Override
    public Optional<SparePart> handle(GetSparePartByIdQuery query) {
        return sparePartRepository.findById(query.id());
    }

    @Override
    public Optional<SparePart> handle(GetSparePartByMaterialSerialNumberQuery query) {
        return sparePartRepository.findByMaterialSerialNumber(query.materialSerialNumber());
    }

    @Override
    public Optional<SparePart> handle(GetSparePartsByEquipmentIdQuery query) {
        return sparePartRepository.findByEquipmentId(query.equipmentId());
    }
}
