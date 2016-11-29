package todoapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import todoapp.models.StatusReport;

@Repository
public interface StatusReportRepository extends MongoRepository<StatusReport, String> {
	public List<StatusReport> findByUserId(String userId);
	@SuppressWarnings("unchecked")
	public StatusReport save(StatusReport statusReport);
	public void delete(StatusReport statusReport);
}
