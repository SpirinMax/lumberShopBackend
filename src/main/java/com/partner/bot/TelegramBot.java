package com.partner.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import com.partner.dataObjects.Customer;
import com.partner.dataObjects.OrderLumber;

public class TelegramBot extends TelegramLongPollingBot {
	final private String BOT_TOKEN = "6249405546:AAFWVLFOzAMolgd37m7vypnb2Xvyxwf1ImQ";
	final private String BOT_NAME = "Lumber_Orders_bot";

	@Override
	public void onUpdateReceived(Update update) {
		try {
			if (update.hasMessage() && update.getMessage().hasText()) {
				// Извлекаем из объекта сообщение пользователя
				Message inMess = update.getMessage();
				// Достаем из inMess id чата пользователя
				String chatId = inMess.getChatId().toString();
				if (inMess.getText().equals("/chatId")) {
					// Создаем объект класса SendMessage - наш будущий ответ пользователю
					SendMessage outMess = new SendMessage();
					// Добавляем в наше сообщение id чата а также наш ответ
					outMess.setChatId(chatId);
					outMess.setText(chatId);
					// Отправка в чат
					execute(outMess);
				}
			}
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		return BOT_NAME;
	}

	@Override
	public String getBotToken() {
		return BOT_TOKEN;
	}

	public boolean sendMessage(String text) {
		try {
			// Отправляем сообщение
			Long chatId = (long) 1542746286;
			// Создаем объект класса SendMessage - наш будущий ответ пользователю
			SendMessage outMess = new SendMessage();
			outMess.setParseMode(ParseMode.MARKDOWN);
			// Добавляем в наше сообщение id чата а также наш ответ
			outMess.setChatId(chatId);
			outMess.setText(text);
			// Отправка в чат
			this.execute(outMess);
			return true;
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void sendMessageAboutSuccessfulOrderCreation(Customer customer, OrderLumber order) {
		String phone = customer.getPhone();
		phone = phone.replace(" ", "").replace("-", "");
		String head = "Был создан заказ №" + order.getIdOrder() + "\n";
		String phoneStr = "Телефон клиента: " + "'" + phone + "'" + "\n\n";
		String fio = "ФИО:" + customer.getFIO() + "\n";
		String represent = "Клиент представляет физическое лицо \n";
		String address = "Адресс клиента: " + customer.getAddress() + "\n";
		if (order.getPriceLumber().getCategoryPrice().isDiscount()) {
			represent = "Клиент представляет юридическое лицо \n";
			String nameCompany = "Организация: " + customer.getNameCompany() + "\n";
			address = nameCompany + "Адресс организации: " + customer.getAddressCompany() + "\n";
		}
		String descOrder = "\nПодробности заказа: \n";
		String nameOrder = order.getPriceLumber().getLumber().getNameLumber() + "\n";
		String count = "Куплено " + String.valueOf(order.getQuantity()) + " "
				+ order.getPriceLumber().getCategoryPrice().getNameCategoryPrice() + "\n";
		String price = "Цена: " + String.valueOf(order.getFinalPrice()) + " рублей" + "\n";

		String message = head + phoneStr + fio + represent + address + descOrder + nameOrder + count + price;

		sendMessage(message);
	}

}
