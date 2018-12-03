package zenjob.dao;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;

import zenjob.model.User;

@Resource
public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
