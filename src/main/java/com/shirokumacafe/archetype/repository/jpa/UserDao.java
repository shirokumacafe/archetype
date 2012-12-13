package com.shirokumacafe.archetype.repository.jpa;

import com.shirokumacafe.archetype.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
