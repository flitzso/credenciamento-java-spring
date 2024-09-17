package com.credenciamento.Service;

import com.credenciamento.DTO.CredenciamentoDTO;
import com.credenciamento.Entity.Credenciamento;
import com.credenciamento.Repository.CredenciamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CredenciamentoService {

    @Autowired
    private CredenciamentoRepository credenciamentoRepository;

    // Listar todos os credenciamentos
    public List<Credenciamento> getAllCredenciamentos() {
        return credenciamentoRepository.findAll();
    }

    // Criar um novo credenciamento
    public Credenciamento createCredenciamento(CredenciamentoDTO credenciamentoDTO) {
        Credenciamento credenciamento = new Credenciamento();
        credenciamento.setNome(credenciamentoDTO.getNome());
        credenciamento.setDataDeNascimento(convertStringToDate(credenciamentoDTO.getDataDeNascimento())); // Corrigido
        credenciamento.setCpf(credenciamentoDTO.getCpf());
        credenciamento.setTelefone(credenciamentoDTO.getTelefone());
        credenciamento.setEmail(credenciamentoDTO.getEmail());
        credenciamento.setSenha(credenciamentoDTO.getSenha()); // Atenção: talvez criptografia seja necessária

        return credenciamentoRepository.save(credenciamento);
    }

    // Obter um credenciamento pelo ID
    public Credenciamento getCredenciamento(int id) {
        Optional<Credenciamento> credenciamento = credenciamentoRepository.findById(id);
        return credenciamento.orElse(null);
    }

    // Atualizar um credenciamento existente
    public Credenciamento updateCredenciamento(int id, CredenciamentoDTO credenciamentoDTO) {
        Optional<Credenciamento> optionalCredenciamento = credenciamentoRepository.findById(id);
        if (optionalCredenciamento.isPresent()) {
            Credenciamento credenciamento = optionalCredenciamento.get();
            credenciamento.setNome(credenciamentoDTO.getNome());
            credenciamento.setDataDeNascimento(convertStringToDate(credenciamentoDTO.getDataDeNascimento())); // Corrigido
            credenciamento.setCpf(credenciamentoDTO.getCpf());
            credenciamento.setTelefone(credenciamentoDTO.getTelefone());
            credenciamento.setEmail(credenciamentoDTO.getEmail());
            credenciamento.setSenha(credenciamentoDTO.getSenha());

            return credenciamentoRepository.save(credenciamento);
        }
        return null;
    }

    // Deletar um credenciamento pelo ID
    public void deleteCredenciamento(int id) {
        credenciamentoRepository.deleteById(id);
    }

    // Método para converter String para Date
    private Date convertStringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Ajuste o formato conforme necessário
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Data invalida: " + dateString, e);
        }
    }
}
