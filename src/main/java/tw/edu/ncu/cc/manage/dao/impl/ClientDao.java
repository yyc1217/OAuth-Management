package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IClientDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.Client;

@Repository
public class ClientDao extends AbstractOAuthServiceDao<Client> implements IClientDao {
	
	@Override
	public List<Client> findAll(String username) {
		Assert.hasText(username);
		return getList(joinUrl(userUrl, username, "clients"));
	}

	@Override
	public Optional<Client> find(String clientId){
		Assert.hasText(clientId);
		return get(joinUrl(clientUrl, clientId));
	}

	@Override
	public Client update(Client client){
		Assert.notNull(client);
		return put(joinUrl(clientUrl, client.getId()), client);
	}

	@Override
	public Client create(Client client){
		Assert.notNull(client);
		return post(clientUrl, client);
	}

	@Override
	public void remove(Client client) {
		Assert.notNull(client);
		delete(joinUrl(clientUrl, client.getId()));
	}

	@Override
	public Client refreshSecret(String clientId) {
		Assert.hasText(clientId);
		return post(joinUrl(clientUrl, clientId, "refresh_secret"));
	}
}