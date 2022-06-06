package com.nttdata.createProduct.Util;

import org.springframework.beans.BeanUtils;

import com.nttdata.createProduct.Dto.eWalletDto;
import com.nttdata.createProduct.entity.eWallet;

public class AppUtils {
    public static eWalletDto eWalletEntitytoDto(eWallet ewallet) {
		eWalletDto walletDto=new eWalletDto();
		BeanUtils.copyProperties(ewallet, walletDto);
		return walletDto;
	}
	
	public static eWallet DtoToeWalletEntity(eWalletDto walletDto) {
		eWallet ewallet=new eWallet();
		BeanUtils.copyProperties(walletDto, ewallet);
		return ewallet;
	}
}
