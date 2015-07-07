package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.util.UriComponentsBuilder;

import tw.edu.ncu.cc.manage.dao.IBlacklistClientDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.BlacklistClient;
import tw.edu.ncu.cc.manage.domain.Client;

@Repository
public class BlacklistClientDao  extends AbstractOAuthServiceDao<BlacklistClient> implements IBlacklistClientDao {

	private static final ParameterizedTypeReference<List<BlacklistClient>> parameterizedTypeReference = new ParameterizedTypeReference<List<BlacklistClient>>() {};
	
	@Override
	protected ParameterizedTypeReference<List<BlacklistClient>> parameterizedTypeReferenceForList() {
		return parameterizedTypeReference;
	}

	@Override
	public List<BlacklistClient> search(Client dto) {
		
		String url = UriComponentsBuilder.fromHttpUrl(blacklistClientUrl)
				.queryParam("name", dto.getName())
				.queryParam("id", dto.getId())
				.queryParam("owner", dto.getOwner())
				.queryParam("deleted", dto.isDeleted())
				.build(false).toUriString();
		
		return getList(url);
	}

	@Override
	public BlacklistClient create(BlacklistClient client) {
		return post(blacklistClientUrl, client);
	}

}