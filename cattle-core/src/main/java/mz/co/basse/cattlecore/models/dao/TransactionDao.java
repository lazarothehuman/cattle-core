package mz.co.basse.cattlecore.models.dao;

import java.util.List;

import mz.co.basse.cattlecore.models.Transaction;

public interface TransactionDao {

	public void create(Transaction transaction) ;

	public void update(Transaction transaction);

	public Transaction find(String code);

	public List<Transaction> findAll(Boolean active);

}
