package com.callforcode.eluf.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.callforcode.eluf.dto.ClientNewDTO;
import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.model.enums.TypeClient;
import com.callforcode.eluf.repositories.ClientRepository;
import com.callforcode.eluf.resources.exceptions.FieldMessage;
import com.callforcode.eluf.services.validation.utils.BR;



public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getType().equals(TypeClient.NATURALPERSON.getCod()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}

		if (objDto.getType().equals(TypeClient.LEGALPERSON.getCod()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}

		Client aux = clientRepository.findByMail(objDto.getMail());

		if (aux != null) {
			list.add(new FieldMessage("mail", "Mail já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}