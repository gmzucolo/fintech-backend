package br.com.fiap.fintech.teste;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import br.com.fiap.fintech.bean.AccountModel;
import br.com.fiap.fintech.bean.InvestimentAssetsModel;
import br.com.fiap.fintech.bean.TransactionEarningsModel;
import br.com.fiap.fintech.bean.TransactionExpensesModel;
import br.com.fiap.fintech.bean.UserModel;
import br.com.fiap.fintech.dao.AccountDao;
import br.com.fiap.fintech.dao.InvestimentAssetsDao;
import br.com.fiap.fintech.dao.TransactionEarningsDao;
import br.com.fiap.fintech.dao.TransactionExpensesDao;
import br.com.fiap.fintech.dao.UserDao;

public class Teste {
	
	public static void main(String[] args) throws SQLException {

        UserModel userModel1 = new UserModel(
                1,
                "gustavo",
                12345678910L,
                "teste@teste.com.br",
                123456789,
                55,
                19);

        UserDao userDao1 = new UserDao();
        userDao1.insertUser(userModel1);

        AccountModel accountModel1 = new AccountModel(
                1,
                123,
                1234,
                123456,
                1,
                1);

        AccountDao accountDao1 = new AccountDao();
        accountDao1.insertAccount(accountModel1, userModel1);

        InvestimentAssetsModel investimentAssetsModel1 = new InvestimentAssetsModel(
                1,
                1000.00,
                "cdb_itau",
                Timestamp.from(Instant.now()).toString());

        InvestimentAssetsDao investimentAssetsDao1 = new InvestimentAssetsDao();
        investimentAssetsDao1.insertInvestimentAssets(investimentAssetsModel1, userModel1);

        TransactionEarningsModel transactionEarningsModel1 = new TransactionEarningsModel(
                1,
                10000.00,
                "credito_conta_salario"
        );

        TransactionEarningsDao transactionEarningsDao1 = new TransactionEarningsDao();
        transactionEarningsDao1.insertTransactionEarnings(transactionEarningsModel1, userModel1);

        TransactionExpensesModel transactionExpensesModel1 = new TransactionExpensesModel(
                1,
                1000.00,
                "debito_faculdade"
        );

        TransactionExpensesDao transactionExpensesDao1 = new TransactionExpensesDao();
        transactionExpensesDao1.insertTransactionExpenses(transactionExpensesModel1, userModel1);


        UserModel userModel2 = new UserModel(
                2,
                "adriano",
                12345678911L,
                "teste@teste.com.br",
                123456789,
                55,
                19);

        UserDao userDao2 = new UserDao();
        userDao2.insertUser(userModel2);

        AccountModel accountModel2 = new AccountModel(
                2,
                123,
                1234,
                123457,
                1,
                1);

        AccountDao accountDao2 = new AccountDao();
        accountDao2.insertAccount(accountModel2, userModel2);

        InvestimentAssetsModel investimentAssetsModel2 = new InvestimentAssetsModel(
                2,
                1000.00,
                "cdb itau",
                Timestamp.from(Instant.now()).toString());

        InvestimentAssetsDao investimentAssetsDao2 = new InvestimentAssetsDao();
        investimentAssetsDao2.insertInvestimentAssets(investimentAssetsModel2, userModel2);

        TransactionEarningsModel transactionEarningsModel2 = new TransactionEarningsModel(
                2,
                10000.00,
                "credito - conta salario"
        );

        TransactionEarningsDao transactionEarningsDao2 = new TransactionEarningsDao();
        transactionEarningsDao2.insertTransactionEarnings(transactionEarningsModel2, userModel2);

        TransactionExpensesModel transactionExpensesModel2 = new TransactionExpensesModel(
                2,
                1000.00,
                "debito - faculdade"
        );

        TransactionExpensesDao transactionExpensesDao2 = new TransactionExpensesDao();
        transactionExpensesDao2.insertTransactionExpenses(transactionExpensesModel2, userModel2);


        UserModel userModel3 = new UserModel(
                3,
                "rodrigo",
                12345678912L,
                "teste@teste.com.br",
                123456789,
                55,
                19);

        UserDao userDao3 = new UserDao();
        userDao3.insertUser(userModel3);

        AccountModel accountModel3 = new AccountModel(
                3,
                123,
                1234,
                123458,
                1,
                1);

        AccountDao accountDao3 = new AccountDao();
        accountDao3.insertAccount(accountModel3, userModel3);

        InvestimentAssetsModel investimentAssetsModel3 = new InvestimentAssetsModel(
                3,
                1000.00,
                "cdb itau",
                Timestamp.from(Instant.now()).toString());

        InvestimentAssetsDao investimentAssetsDao3 = new InvestimentAssetsDao();
        investimentAssetsDao3.insertInvestimentAssets(investimentAssetsModel3, userModel3);

        TransactionEarningsModel transactionEarningsModel3 = new TransactionEarningsModel(
                3,
                10000.00,
                "credito - conta salario"
        );

        TransactionEarningsDao transactionEarningsDao3 = new TransactionEarningsDao();
        transactionEarningsDao3.insertTransactionEarnings(transactionEarningsModel3, userModel3);

        TransactionExpensesModel transactionExpensesModel3 = new TransactionExpensesModel(
                3,
                1000.00,
                "debito - faculdade"
        );

        TransactionExpensesDao transactionExpensesDao3 = new TransactionExpensesDao();
        transactionExpensesDao3.insertTransactionExpenses(transactionExpensesModel3, userModel3);


//        UserModel userModel4 = new UserModel(
//                4,
//                "fernanda",
//                12345678913L,
//                "teste@teste.com.br",
//                123456789,
//                55,
//                19);
//
//        UserDao userDao4 = new UserDao();
//        userDao4.insertUser(userModel4);
//
//        AccountModel accountModel4 = new AccountModel(
//                4,
//                123,
//                1234,
//                123459,
//                1,
//                1);
//
//        AccountDao accountDao4 = new AccountDao();
//        accountDao4.insertAccount(accountModel4, userModel4);
//
//        InvestimentAssetsModel investimentAssetsModel4 = new InvestimentAssetsModel(
//                4,
//                1000.00,
//                "cdb itau",
//                Timestamp.from(Instant.now()).toString());
//
//        InvestimentAssetsDao investimentAssetsDao4 = new InvestimentAssetsDao();
//        investimentAssetsDao4.insertInvestimentAssets(investimentAssetsModel4, userModel4);
//
//        TransactionEarningsModel transactionEarningsModel4 = new TransactionEarningsModel(
//                4,
//                10000.00,
//                "credito - conta salario"
//        );
//
//        TransactionEarningsDao transactionEarningsDao4 = new TransactionEarningsDao();
//        transactionEarningsDao4.insertTransactionEarnings(transactionEarningsModel4, userModel4);
//
//        TransactionExpensesModel transactionExpensesModel4 = new TransactionExpensesModel(
//                4,
//                1000.00,
//                "debito - faculdade"
//        );
//
//        TransactionExpensesDao transactionExpensesDao4 = new TransactionExpensesDao();
//        transactionExpensesDao4.insertTransactionExpenses(transactionExpensesModel4, userModel4);
//
//
//        UserModel userModel5 = new UserModel(
//                5,
//                "thiago",
//                12345678914L,
//                "teste@teste.com.br",
//                123456789,
//                55,
//                19);
//
//        UserDao userDao5 = new UserDao();
//        userDao5.insertUser(userModel5);
//
//        AccountModel accountModel5 = new AccountModel(
//                5,
//                123,
//                1234,
//                123451,
//                1,
//                1);
//
//        AccountDao accountDao5 = new AccountDao();
//        accountDao5.insertAccount(accountModel5, userModel5);
//
//        InvestimentAssetsModel investimentAssetsModel5 = new InvestimentAssetsModel(
//                5,
//                1000.00,
//                "cdb itau",
//                Timestamp.from(Instant.now()).toString());
//
//        InvestimentAssetsDao investimentAssetsDao5 = new InvestimentAssetsDao();
//        investimentAssetsDao5.insertInvestimentAssets(investimentAssetsModel5, userModel5);
//
//        TransactionEarningsModel transactionEarningsModel5 = new TransactionEarningsModel(
//                5,
//                10000.00,
//                "credito - conta salario"
//        );
//
//        TransactionEarningsDao transactionEarningsDao5 = new TransactionEarningsDao();
//        transactionEarningsDao5.insertTransactionEarnings(transactionEarningsModel5, userModel5);
//
//        TransactionExpensesModel transactionExpensesModel5 = new TransactionExpensesModel(
//                5,
//                1000.00,
//                "debito - faculdade"
//        );
//
//        TransactionExpensesDao transactionExpensesDao5 = new TransactionExpensesDao();
//        transactionExpensesDao5.insertTransactionExpenses(transactionExpensesModel5, userModel5);
    }
}

