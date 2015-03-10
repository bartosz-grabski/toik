package pl.edu.agh.dao;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import pl.edu.agh.account.Account;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlMap;

@Named
public class AccountXmlDAO implements AccountDAO {
	private static final Logger logger = LoggerFactory.getLogger(AccountXmlDAO.class);

	private XmlMap xmlMap;
	private AtomicLong idSequence;

	@Inject
	@SuppressWarnings("unchecked")
	public AccountXmlDAO(@Value("${db.path}") final String path) {
		File storageRoot = new File(path);
		logger.info("Storage: " + storageRoot.getAbsolutePath());

		XStream xstream = new XStream();

		xmlMap = new XmlMap(new FilePersistenceStrategy(storageRoot, xstream));

		long initialValue = 0;
		if (!xmlMap.isEmpty()) {
			initialValue = Collections.max(xmlMap.keySet());
		}

		logger.info("Initial value id: {}", initialValue);
		idSequence = new AtomicLong(initialValue);
	}

	@SuppressWarnings("unchecked")
	public synchronized Collection<Account> getAccounts() {
		logger.info("Get all accounts.");
		return xmlMap.values();
	}

	public synchronized Account getAccountByID(Long id) {
		logger.info("Get Account with id: {}", id);
		return (Account) xmlMap.get(id);
	}

	public synchronized long saveAccount(Account account) {
		long id = idSequence.incrementAndGet();
		account.setId(id);

		xmlMap.put(id, account);
		logger.info("Save account: {}", account);
		return id;
	}

	@SuppressWarnings("unchecked")
	public Collection<Long> getIds() {
		return xmlMap.keySet();
	}
}
