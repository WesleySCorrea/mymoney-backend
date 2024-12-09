package app.web.mymoney.services;

import app.web.mymoney.DTOs.request.TransactionsRequestDTO;
import app.web.mymoney.DTOs.response.TransactionsResponseDTO;

public interface TransactionService {

    TransactionsResponseDTO createTransaction(TransactionsRequestDTO transactionsRequestDTO);
}
