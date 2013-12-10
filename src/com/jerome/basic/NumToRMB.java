package com.jerome.basic;

import java.math.BigDecimal;

/**
 * 
 * ClassName:NumToRMB <br>
 * Function: 数值转化为人民币大写<br>
 *
 * @author   Administrator
 * @version  
 * @Date	 2013	2013-12-9		下午3:01:43
 *
 * @see
 */
public class NumToRMB {

	public static void main(String[] args) {
		System.out.println(changeToBig(Double.parseDouble("1000.855")));
	}

	public static String changeToBig(double value) {
		char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
		char[] vunit = { '万', '亿' }; // 段名表示
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
		// long midVal = (long)(value*100); ////存在精度问题,如0.9->0.8999
		BigDecimal midVal = new BigDecimal(Math.round(value * 100)); // 转化成整形,替换上句
		
		String valStr = String.valueOf(midVal); // 转化成字符串
		String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
		String rail = valStr.substring(valStr.length() - 2); // 取小数部分

		String prefix = ""; // 整数部分转化的结果
		String suffix = ""; // 小数部分转化的结果
		// 处理小数点后面的数
		if (rail.equals("00")) { // 如果小数部分为0
			suffix = "整";
		} else {
			suffix = digit[rail.charAt(0) - '0'] + "角"
					+ digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
		}
		// 处理小数点前面的数
		char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
		boolean preZero = false; // 标志当前位的上一位是否为有效0位（如万位的0对千位无效）
		byte zeroSerNum = 0; // 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
			int idx = (chDig.length - i - 1) % 4; // 数字处于哪位，然后映射到char[] hunit = { '拾', '佰', '仟' };的下标
			System.out.println("段位置-index:" + idx + ".." + (chDig.length - i - 1));
			int vidx = (chDig.length - i - 1) / 4; //同上，找到对应char[] vunit = { '万', '亿' };的下标
			System.out.println("段名-index" + ".." + (chDig.length - i - 1) / 4);
			if (chDig[i] == '0') { // 如果当前字符是0
				preZero = true;
				zeroSerNum++; // 连续0次数递增
				if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					preZero = false; // 不管上一位是否为0，置为无效0位
				}
			} else {
				zeroSerNum = 0; // 连续0次数清零
				if (preZero) { // 上一位为有效0位
					prefix += digit[0]; // 只有在这地方用到'零'
					preZero = false;
				}
				prefix += digit[chDig[i] - '0']; // 转化该数字表示
				System.out.println(chDig[i] - '0');
				if (idx > 0)
					prefix += hunit[idx - 1];
				if (idx == 0 && vidx > 0) {
					prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
				}
			}
		}

		if (prefix.length() > 0)
			prefix += '圆'; // 如果整数部分存在,则有圆的字样
		return prefix + suffix; // 返回正确表示
	}
}