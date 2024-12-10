package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.request.TransactionsRequestDTO;
import app.web.mymoney.DTOs.response.TransactionsResponseDTO;
import app.web.mymoney.entities.Transactions;
import app.web.mymoney.repositories.TransactionRepository;
import app.web.mymoney.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public TransactionsResponseDTO createTransaction(TransactionsRequestDTO transactionsRequestDTO) {

        Transactions transaction =transactionsRequestDTO.toEntity();

        transaction = transactionRepository.save(transaction);

        return new TransactionsResponseDTO(transaction);
    }
}
