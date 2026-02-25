package com.delcons.professionalservice.domain.port.in;

import com.delcons.professionalservice.domain.model.Professional;

public interface CreateProfessionalUseCase {
    Professional createProfessional(Professional professional);
}
