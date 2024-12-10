package app.web.mymoney.services;

import app.web.mymoney.DTOs.request.transaction.TransactionsRequestDTO;
import app.web.mymoney.DTOs.response.transaction.TransactionsResponseDTO;

public interface TransactionService {

    TransactionsResponseDTO createTransaction(TransactionsRequestDTO transactionsRequestDTO);
}
