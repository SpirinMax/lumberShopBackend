package com.partner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.partner.bot.TelegramBot;

@ComponentScan(basePackages = { "com.partner.controllers", "com.partner.service" })
@EntityScan(basePackages = "com.partner.dataObjects")
@EnableJpaRepositories(basePackages = "com.partner.dataCrudInterfaces")
@SpringBootApplication
@EnableTransactionManagement
public class PartnerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnerProjectApplication.class, args);
		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(new TelegramBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
