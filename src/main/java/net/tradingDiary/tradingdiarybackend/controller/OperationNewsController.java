package net.tradingDiary.tradingdiarybackend.controller;

import net.tradingDiary.tradingdiarybackend.entity.OperationNews;
import net.tradingDiary.tradingdiarybackend.payroll.OperationNotFoundException;
import net.tradingDiary.tradingdiarybackend.repository.OperationNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin("https://qg-trading.netlify.app/")
@CrossOrigin("http://localhost:8081/")
public class OperationNewsController {
    @Autowired
    private OperationNewsRepository operationNewsRepository;

    @GetMapping("/operations/news")
    public List<OperationNews> fetchOperations() {
        return operationNewsRepository.findAll();
    }

    @PostMapping("/add-operation/news")
    OperationNews newOperation(@RequestBody OperationNews newOperation) {
        return operationNewsRepository.save(newOperation);
    }

    @DeleteMapping("/delete-operation/news/{id}")
    void deleteOperation(@PathVariable Long id) {
        operationNewsRepository.deleteById(id);
    }

    @GetMapping("/operation/news/{id}")
    OperationNews getOperation(@PathVariable Long id) {
        return operationNewsRepository.findById(id).orElseThrow(() -> new OperationNotFoundException(id));
    }

    @PutMapping("/operation/news/{id}")
    OperationNews editOperation(@RequestBody OperationNews editOperation, @PathVariable long id) {
        return operationNewsRepository.findById(id)
                .map(operationNews -> {
                    operationNews.setData(editOperation.getData());
                    operationNews.setTime(editOperation.getTime());
                    operationNews.setResult(editOperation.getResult());
                    operationNews.setNews(Collections.singletonList(editOperation.getNews()));
                    operationNews.setTargetPoints(editOperation.getTargetPoints());
                    operationNews.setStopPoints(editOperation.getStopPoints());
                    operationNews.setComments(editOperation.getComments());
                    operationNews.setImage(editOperation.getImage());
                    return operationNewsRepository.save(operationNews);
                })
                .orElseGet(() -> {
                    editOperation.setId(id);
                    return operationNewsRepository.save(editOperation);
                });
    }
}
