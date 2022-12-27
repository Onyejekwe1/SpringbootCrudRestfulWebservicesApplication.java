package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Land;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandRepository extends JpaRepository<Land, Long> {
    Optional<Land> findBySerialNumber(String serialNumber);
}
