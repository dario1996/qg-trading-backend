package net.tradingDiary.tradingdiarybackend.repository;

import net.tradingDiary.tradingdiarybackend.entity.OperationNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationNewsRepository extends JpaRepository<OperationNews, Long> {
}
