package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpUtil {
	/**
	 * 去除HTML标签
	 */
	// 定义一个地址
	public static String URL_BASE = "http://127.0.0.1:8081/my?type=";

	public static String delHTMLTag(String htmlStr) {
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
		String regEx_test = "请求数据返回预览界面";

		Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签

		Pattern p_text = Pattern.compile(regEx_test, Pattern.CASE_INSENSITIVE);
		Matcher m_text = p_text.matcher(htmlStr);
		htmlStr = m_text.replaceAll(""); // 过滤html标签

		return htmlStr.trim(); // 返回文本字符串
	}
}
