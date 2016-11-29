package todoapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import todoapp.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public List<User> findAll();
	public User findOne(String id);
	public User findByUserId(String userId);
	public User save(User todo);
	public void delete(User todo);
}
