package com.example.recarga.service;

import com.example.recarga.dto.ClientDTO;
import com.example.recarga.entity.Client;
import com.example.recarga.repository.ClientRepository;
import com.example.recarga.service.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);

    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {

        Client client = new Client();
        client.setName(dto.getName());
        client.setPhone(dto.getPhone());

        client = repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {

        Client client = repository.getReferenceById(id);
        client.setName(dto.getName());
        client.setPhone(dto.getPhone());
        return new ClientDTO(client);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

