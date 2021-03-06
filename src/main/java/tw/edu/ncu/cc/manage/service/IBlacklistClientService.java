package tw.edu.ncu.cc.manage.service;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.BlacklistClient;
import tw.edu.ncu.cc.manage.domain.Client;

public interface IBlacklistClientService {

	List<BlacklistClient> search(Client dto);

	BlacklistClient create(BlacklistClient client);

	void remove(BlacklistClient blacklistClient);

	Optional<BlacklistClient> find(String clientId);

}
