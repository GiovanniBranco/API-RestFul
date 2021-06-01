package org.serratec.projeto03.mapper;

import org.serratec.projeto03.model.dto.ContaDto;
import org.serratec.projeto03.models.ContaEntity;
import org.springframework.stereotype.Component;

@Component
public class ContaMapper {

	public ContaEntity toEntity(ContaDto dto) {
		ContaEntity entity = new ContaEntity();
		
		entity.setTitular(dto.getTitular());
		entity.setSaldo(dto.getSaldo());
		
		return entity;
	}
	
	public ContaDto toDto(ContaEntity entity) {
		ContaDto dto = new ContaDto();
		
		dto.setTitular(entity.getTitular());
		dto.setSaldo(entity.getSaldo());
		
		return dto;
	}
}
