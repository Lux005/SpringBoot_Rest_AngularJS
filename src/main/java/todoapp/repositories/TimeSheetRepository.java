package todoapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import todoapp.models.TimeSheet;

@Repository
public interface TimeSheetRepository extends MongoRepository<TimeSheet, String> {
	
	public List<TimeSheet> findByUserId(String userId);
	public List<TimeSheet> findByUserIdAndCompletedIsTrue(String userId);
	public TimeSheet findByUserIdAndCompletedIsFalse(String userId);
	public TimeSheet findOne(String id);
	@SuppressWarnings("unchecked")
	public TimeSheet save(TimeSheet timeSheet);
	public void delete(TimeSheet timeSheet);
}
