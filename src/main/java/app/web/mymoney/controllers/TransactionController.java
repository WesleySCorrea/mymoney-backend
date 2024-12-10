package app.web.mymoney.controllers;

import app.web.mymoney.DTOs.request.transaction.TransactionsRequestDTO;
import app.web.mymoney.DTOs.response.transaction.TransactionsResponseDTO;
import app.web.mymoney.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionsResponseDTO> createTransaction(@RequestBody TransactionsRequestDTO transactionsRequestDTO) {

        TransactionsResponseDTO transactionsResponseDTO = transactionService.createTransaction(transactionsRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(transactionsResponseDTO);
    }
}
