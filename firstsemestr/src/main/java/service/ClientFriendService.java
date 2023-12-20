package service;

import model.ClientFriends;
import repository.ClientFriendsRepository;

public class ClientFriendService {

    private ClientFriendsRepository repository;

    public ClientFriendService() {
        repository = new ClientFriendsRepository();
    }

    public ClientFriends save(ClientFriends clientFriends) {
        return repository.save(clientFriends);
    }

    public String findByUserName(String username) { return repository.findByUserName(username);
    }
}
