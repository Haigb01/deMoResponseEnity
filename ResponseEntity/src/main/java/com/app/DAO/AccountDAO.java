package com.app.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Bean.Account;
;
@Repository
public interface AccountDAO extends JpaRepository<Account, String>{
	
		List<Account> findAllByActivatedAndAdmin(Boolean actived, Boolean admin);

}
