package todoapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import todoapp.models.RequestLetter;

@Repository
public interface RequestLetterRepository extends MongoRepository<RequestLetter, String> {
	public List<RequestLetter> findByUserId(String userId);
	@SuppressWarnings("unchecked")
	public RequestLetter save(RequestLetter requestletter);
	public void delete(RequestLetter requestletter);
}
