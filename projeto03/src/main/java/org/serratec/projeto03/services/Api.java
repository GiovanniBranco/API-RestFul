package org.serratec.projeto03.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto03.exceptions.ContaNotFound;
import org.serratec.projeto03.models.Conta;
import org.serratec.projeto03.models.Operacao;
import org.serratec.projeto03.models.TipoOperacao;
import org.springframework.stereotype.Service;

@Service
public class Api {
	List<Conta> contas = new ArrayList<>();
	
	private Conta getByID(Integer id) throws ContaNotFound {
		if(id != null) {		
			for (Conta conta : contas) {
				if(conta.getId().equals(id)) {
					return conta;
				}	
			}
		}	
		throw new ContaNotFound("Id não encontrado");
	}
	
	public List<Conta> getAll(){
		return contas;
	}
	

	public Conta getOne(Integer id) throws ContaNotFound {
		return this.getByID(id);
	}
	
	public Conta create(Conta conta) {
		for (Conta c : contas) {
			if(c.equals(conta)) {
				return null;
			}	
		}
		contas.add(conta);
		return conta;	
	}
	
	public Conta update(Integer id, Conta obj) throws ContaNotFound {
		Conta conta = this.getByID(id);

		if (conta != null) {
			if (obj.getTitular() != null) {
				conta.setTitular(obj.getTitular());
			}
			contas.set(contas.indexOf(conta), conta);
			return conta;
		}
		return null;
	}
	
	public String delete(Integer id) throws ContaNotFound {
		Conta conta = this.getByID(id);
		
		if(conta != null) {
			contas.remove(conta);
			return "Conta deletada com sucesso!";
		}
		return null;
	}
	
	
	
	public Conta atualizarSaldo(Integer id, Operacao operacao) throws ContaNotFound {
		Conta conta = this.getByID(id);
		
		if(operacao.getOperacao().equals(TipoOperacao.DEBITO))  {
			Double total = (conta.getSaldo() + operacao.getValor());
			conta.setSaldo(total);
			return conta;
		}else if(operacao.getOperacao().equals(TipoOperacao.CREDITO)){
			if(conta.getSaldo() < operacao.getValor()) {
				throw new ContaNotFound("Saldo inferior ao valor de crédito");
			}
			else {
				Double total = (conta.getSaldo() - operacao.getValor());
				conta.setSaldo(total);
				return conta;				
			}
		}
		else {
			return null;
		}
	}
}