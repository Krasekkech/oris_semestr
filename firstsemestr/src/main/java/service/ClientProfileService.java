package service;

import model.Client;
import model.ClientProfile;
import repository.ClientProfileRepository;
import repository.ClientRepository;

public class ClientProfileService {

    private ClientProfileRepository repository;

    public ClientProfileService() {
        repository = new ClientProfileRepository();
    }

    public ClientProfile save(ClientProfile clientProfile) {
        return repository.save(clientProfile);
    }

    public ClientProfile findById(Long id) {
        return repository.findById(id);
    }
}
