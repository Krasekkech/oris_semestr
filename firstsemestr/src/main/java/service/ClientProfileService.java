package service;

import model.ClientProfile;
import repository.ClientProfileRepository;

public class ClientProfileService {

    private ClientProfileRepository repository;

    public ClientProfileService() {
        repository = new ClientProfileRepository();
    }

    public ClientProfile save(ClientProfile clientProfile) {
        return repository.save(clientProfile);
    }

    public String findById(Long id) {
        return repository.findById(id);
    }

    public String findAll() {
        return repository.findAll();
    }

    public String findByUserName(String username) {
        return repository.findByUserName(username);
    }

    public ClientProfile update(ClientProfile clientProfile) {
        return repository.update(clientProfile);
    }

    public ClientProfile delete(String username) { return repository.delete(username);
    }


    //public void update(ClientProfile clientProfile) {
}
