package com.nttdata.createProduct.consumer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


import com.nttdata.createProduct.entity.Product;
import com.nttdata.createProduct.entity.Transaction;
import com.nttdata.createProduct.repository.ProductRepositoryKafka;
import com.nttdata.createProduct.repository.TransactionRepositoryKafka;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class KafkaConsumer {
	
	@Autowired
	private ProductRepositoryKafka repo;

	@Autowired
	private TransactionRepositoryKafka repoTrans;



	@KafkaListener(topics="${kafka.subscribed-topic.name}")
	public void consumeEvent(String message) {
		log.info("va a leer");
		log.info(message);
		String[] data = message.split("%%");
		String idTrans = data[0];
		Double amount = Double.parseDouble(data[1]);
		String origin = data[2];
		String destination = data[3];
		Double  purchaseRate = Double.parseDouble(data[4]); 
		Double sellingRate = Double.parseDouble(data[5]);

		//Transaction trans = Mapper.OBJECT_MAPPER.readValue(sTrans, Transaction.class);

		//Actualizar monederos
		//Monedero origen (quien vende)
		Double newAmountMoney = amount * sellingRate;
		Optional <Product> product_1 = repo.findById(origin);
		Product temp_1 = Product.class.cast(product_1.get());

		if (product_1.isPresent()) {
			temp_1.setAmount(temp_1.getAmount() + newAmountMoney);
			temp_1.setAmountBootCoin(temp_1.getAmountBootCoin() - amount);
			repo.save(temp_1);
		} 

		//Monedero destino (quien compra)
		Double newAmountMoneyDestination = amount * purchaseRate * -1; 
		Optional <Product> product_2 = repo.findById(destination);
		Product temp_2 = Product.class.cast(product_2.get());

		if (product_2.isPresent()) {
			temp_2.setAmount(temp_2.getAmount() + newAmountMoneyDestination);
			temp_2.setAmountBootCoin(temp_2.getAmountBootCoin() + amount);
			repo.save(temp_2);
		}  

		//Actualizar estado de transacción
		Optional <Transaction> transaction = repoTrans.findById(idTrans);
		Transaction temp_trans = Transaction.class.cast(transaction.get());

		if (transaction.isPresent()) {
			temp_trans.setOperationStatus("SUCCESSFUL");
			repoTrans.save(temp_trans);
		}

		log.info("Transacción actualizada, productos actualizados, idTransaction -> ", idTrans );
		
	}
}
