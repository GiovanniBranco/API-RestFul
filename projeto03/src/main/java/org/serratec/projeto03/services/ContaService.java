package org.serratec.projeto03.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projeto03.enums.TipoOperacao;
import org.serratec.projeto03.exceptions.ContaNotFound;
import org.serratec.projeto03.exceptions.SaldoNegativo;
import org.serratec.projeto03.mapper.ContaMapper;
import org.serratec.projeto03.model.dto.ContaDto;
import org.serratec.projeto03.models.ContaEntity;
import org.serratec.projeto03.models.Operacao;
import org.serratec.projeto03.repositorys.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
	
	@Autowired
	ContaRepository repository;
	
	@Autowired
	ContaMapper mapper;
	
	
	public ContaEntity getById(Integer id) throws ContaNotFound {
		Optional<ContaEntity> conta = repository.findById(id);
		
		if(conta.isEmpty()) {
			throw new ContaNotFound("Id não encontrado");			
		}		
			return conta.get();		
	}
	
	public List<ContaEntity> getByName(String titular) throws ContaNotFound {
		return repository.findByTitularOrderById(titular);

	}
	 	
	public List<ContaEntity> getAll(){
		return repository.findAll();
	}
		
	public ContaEntity create(ContaEntity conta) {
		return repository.save(conta);
	}
	
	public ContaEntity update(Integer id, ContaEntity obj) throws ContaNotFound {
		ContaEntity conta = this.getById(id);

			if (obj.getTitular() != null) {
				conta.setTitular(obj.getTitular());
			}
			return repository.save(conta);
	}
	
	public String delete(Integer id){
			repository.deleteById(id);
			return "Conta deletada com sucesso!";
	}
	
	public ContaDto atualizarSaldo(Integer id, Operacao operacao) throws SaldoNegativo, ContaNotFound {
		ContaEntity conta = this.getById(id);
		

		if (operacao.getOperacao().equals(TipoOperacao.CREDITO)) {
			Double total = (conta.getSaldo() + operacao.getValor());
			conta.setSaldo(total);
			
			return mapper.toDto(repository.save(conta));
		} else if (operacao.getOperacao().equals(TipoOperacao.DEBITO)) {
			if (conta.getSaldo() < operacao.getValor()) {
				throw new SaldoNegativo("Saldo inferior ao valor de débito");
			} else {
				Double total = (conta.getSaldo() - operacao.getValor());
				conta.setSaldo(total);
				return mapper.toDto(repository.save(conta));
				
			}
		} else {
			return null;
		}
	}
}
