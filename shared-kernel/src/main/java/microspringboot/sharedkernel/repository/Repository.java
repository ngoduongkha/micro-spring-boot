package microspringboot.sharedkernel.repository;

import microspringboot.sharedkernel.domain.AggregateRoot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Repository<T extends AggregateRoot<T>> extends JpaRepository<T, UUID> {
}
