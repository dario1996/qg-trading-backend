package net.tradingDiary.tradingdiarybackend.repository;

import net.tradingDiary.tradingdiarybackend.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
