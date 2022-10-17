package mintic.Reto51.Repository.CrudRepository;

import mintic.Reto51.Entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
