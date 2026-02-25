package com.delcons.professionalservice.domain.port.in;

import com.delcons.professionalservice.domain.model.Professional;

public interface UpdateProfessionalUseCase {
    Professional updateProfessional(Professional professional);
}
