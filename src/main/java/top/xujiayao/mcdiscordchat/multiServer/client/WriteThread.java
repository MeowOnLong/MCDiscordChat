package top.xujiayao.mcdiscordchat.multiServer.client;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static top.xujiayao.mcdiscordchat.Main.LOGGER;

/**
 * @author Xujiayao
 */
public class WriteThread extends Thread {

	private PrintWriter writer;

	public WriteThread(Socket socket) {
		try {
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		}
	}

	public void write(String text) {
		writer.println(text);
	}
}