package net.tradingDiary.tradingdiarybackend.controller;

import net.tradingDiary.tradingdiarybackend.entity.Operation;
import net.tradingDiary.tradingdiarybackend.payroll.OperationNotFoundException;
import net.tradingDiary.tradingdiarybackend.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin("https://qg-trading.netlify.app/")
@CrossOrigin("http://localhost:8081/")
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("/operations")
    public List<Operation> fetchOperations() {
        return operationRepository.findAll();
    }

    @PostMapping("/add-operation")
    Operation newOperation(@RequestBody Operation newOperation) {
        return operationRepository.save(newOperation);
    }

    @DeleteMapping("/delete-operation/{id}")
    void deleteOperation(@PathVariable Long id) {
        operationRepository.deleteById(id);
    }

    @GetMapping("/operation/{id}")
    Operation getOperation(@PathVariable Long id) {
        return operationRepository.findById(id).orElseThrow(() -> new OperationNotFoundException(id));
    }

    @PutMapping("/operation/{id}")
    Operation editOperation(@RequestBody Operation editOperation, @PathVariable long id) {
        return operationRepository.findById(id)
                .map(operation -> {
                    operation.setData(editOperation.getData());
                    operation.setTime(editOperation.getTime());
                    operation.setResult(editOperation.getResult());
                    operation.setDynamic(editOperation.getDynamic());
                    operation.setTargetPoints(editOperation.getTargetPoints());
                    operation.setStopPoints(editOperation.getStopPoints());
                    operation.setComments(editOperation.getComments());
                    operation.setImage(editOperation.getImage());
                    return operationRepository.save(operation);
                })
                .orElseGet(() -> {
                    editOperation.setId(id);
                    return operationRepository.save(editOperation);
                });
    }
}
