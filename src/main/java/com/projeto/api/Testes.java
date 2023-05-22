package com.projeto.api;

import java.time.LocalDate;

public class Testes {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.parse("2014-01-01");
		System.out.println(date);
		System.out.println(LocalDate.now().minusYears(18));
		if (!date.isBefore(LocalDate.now().minusYears(18)))
			System.out.println("Menor!");
		
	}
}
