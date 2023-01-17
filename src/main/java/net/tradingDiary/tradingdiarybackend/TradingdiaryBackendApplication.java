package net.tradingDiary.tradingdiarybackend;


import net.tradingDiary.tradingdiarybackend.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TradingdiaryBackendApplication implements CommandLineRunner {

	@Autowired
	private OperationRepository operationRepository;

	public static void main(String[] args) {
		SpringApplication.run(TradingdiaryBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
