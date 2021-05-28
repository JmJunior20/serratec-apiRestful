package org.serratec.backend.projeto04.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projeto04.entity.ContaEntity;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
	
	List<ContaEntity> list = new ArrayList<ContaEntity>();
	
	public ContaEntity create(ContaEntity conta) {
		list.add(conta);
		return conta;
	}
	
	public List<ContaEntity> getAll() {
		return this.list;
	}
	
	public ContaEntity procurar(Integer numero) {
		for (ContaEntity contaEntity : list) {
			if (contaEntity.getNumero() == numero) {
				return contaEntity;
			}
		}
		System.out.println("Id não encontrado");
		return null;
	}
	
	public ContaEntity update(Integer numero, ContaEntity conta) {
		for (ContaEntity contaEntity : list) {
			if (contaEntity.getNumero() == numero) {
				if (conta.getTitular() != null) {
					contaEntity.setTitular(conta.getTitular());
				}
				if (contaEntity.getSaldo() != null) {
					contaEntity.setSaldo(conta.getSaldo());
				}
				return contaEntity;
			}
		}
		System.out.println("Não temos tarefas com esse id");
		return null;
	}
	
	public String delete(Integer numero) {
		for (ContaEntity contaEntity : list) {
			if (contaEntity.getNumero() == numero) {
				list.remove(contaEntity);
				return "Deletado com sucesso";
			}
		}
		return "Id não encontrado";
	}
}
