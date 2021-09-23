package com.dbs.web.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dbs.web.beans.Customer;
import com.dbs.web.beans.Transaction;
import com.dbs.web.exceptions.TransactionNotValidException;
import com.dbs.web.repository.CustomerRepository;
import com.dbs.web.repository.TransactionRepository;
import com.dbs.web.utils.Permutation;
import com.dbs.web.utils.TransferType;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transRepo;

	@Autowired
	BankService bankBicService;

	@Autowired
	CustomerService custService;

	@Autowired
	CustomerRepository custRepo;

	@Autowired
	MessageService msgService;

	public Transaction saveTransaction(com.dbs.web.dto.TransactionRequestDto trans) {
		String transferType = trans.getTransferType();
		String receiverName = trans.getReceiverName().strip().toUpperCase();
		Customer cust = custService.findById(trans.getSenderAcctNumber());
		String custName = cust.getAccountholdername();

		System.out.println(trans);
		
		// validate transferType field
		if(!transferType.equals("BANK") && !transferType.equals("CUSTOMER")) {
			throw new TransactionNotValidException("The transfer type is not recognizable");
		}
		if ((transferType.equals("BANK")
				&& (!receiverName.startsWith("HDFC BANK") || !custName.startsWith("HDFC BANK")))
				|| (transferType.equals("CUSTOMER")
						&& (receiverName.startsWith("HDFC BANK") || custName.startsWith("HDFC BANK")))) {
			throw new TransactionNotValidException("The transfer type has been set incorrectly");
		}

		if (trans.getAmount().equals(0)) {
			throw new TransactionNotValidException("Amount should be greater than zero");
		}

		Double amount = trans.getAmount();
		Double transFee = amount * 0.0025;

		cust = custService.findById(trans.getSenderAcctNumber());
		Double custAcctBalance = cust.getClearbalance();

		if ((amount + transFee) > custAcctBalance && cust.getOverdraftflag().equals("NO")) {
			throw new TransactionNotValidException(
					"The sender doesn't have enough amount to complete the transaction.");
		}

		try {
			if (isReceiverInSdnList(trans.getReceiverName())) {
				throw new TransactionNotValidException(
						"The receiver is in SDN list, the transaction cannot be processed");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Transaction transaction = new Transaction();
		transaction.setMessagecode(msgService.findById(trans.getMessageCode().strip()));
		transaction.setReceiveraccountholdernumber(trans.getReceiverAcctNumber().strip());
		transaction.setReceiverBIC(bankBicService.findById(trans.getReceiverBic().strip()));
		transaction.setReceiveraccountholdername(trans.getReceiverName().strip());
		transaction.setTransferdate(new Date());
		transaction.setInramount(amount);
		transaction.setTransfertypecode(trans.getTransferType().equals("BANK") ? TransferType.BANK : TransferType.CUSTOMER);
		cust.setClearbalance(custAcctBalance - (amount + transFee));
		custRepo.save(cust);

		transaction.setCustomer(custService.findById(cust.getCustomerid()));
		transaction = transRepo.save(transaction);

		return transaction;

	}

	private boolean isReceiverInSdnList(String name) throws FileNotFoundException {
		String[] l = name.strip().split(" ");

		List<String> permList = Permutation.findPermutations(l, ' ');
		String regexp = String.join("|", permList);
		File file = ResourceUtils.getFile("classpath:sdnlist.txt");

		Scanner fileScanner = new Scanner(file);

		boolean matchFound = false;

		Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = null;
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			matcher = pattern.matcher(line);
			if (matcher.find()) {
				matchFound = true;
				break;
			}
		}

		return matchFound;
	}

}