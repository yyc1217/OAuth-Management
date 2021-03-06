package tw.edu.ncu.cc.manage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IBlacklistClientDao;
import tw.edu.ncu.cc.manage.domain.BlacklistClient;
import tw.edu.ncu.cc.manage.domain.Client;
import tw.edu.ncu.cc.manage.service.IBlacklistClientService;

@Service
public class BlacklistClientService implements IBlacklistClientService {

	@Autowired
	private IBlacklistClientDao blacklistClientDao;

	@Override
	public List<BlacklistClient> search(Client dto) {
		return this.blacklistClientDao.search(dto);
	}

	@Override
	public BlacklistClient create(BlacklistClient client) {
		return this.blacklistClientDao.create(client);
	}

	@Override
	public void remove(BlacklistClient client) {
		this.blacklistClientDao.remove(client);
	}
	
	@Override
	public Optional<BlacklistClient> find(String clientId) {
		return this.blacklistClientDao.find(clientId);
	}
}
