package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProducerApp {
	public static void main(String[] args) throws IOException, TimeoutException {
		Connection connection = null;
		Channel channel = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			factory.setPort(5672);
			factory.setUsername("admin");
			factory.setPassword("123456");
			factory.setVirtualHost("/");

			// ������RabbitMQ��������TCP����
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare("firstQueue", true, false, false, null);
			String message = "First Message";
			channel.basicPublish("", "firstQueue", null, message.getBytes());
			System.out.println("Send Message is:'" + message + "'");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (channel != null) {
				channel.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
}
