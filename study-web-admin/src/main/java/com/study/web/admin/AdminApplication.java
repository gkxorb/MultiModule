package com.study.web.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.study.ComponentScanBasePackage;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanBasePackage.class})
@RestController
@Slf4j
public class AdminApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(AdminApplication.class, args);
		System.out.println("test!!");
	}
		


	/*
	Ctrl+b, Ctrl+j : 
	Alt+위,아래 : 코드라인 이동
	Shit+Alt +위,아래 : 코드 복사
	Alt+좌,우 : 이전,이후 작업 위치 이동
	Ctrl+/ : 선택 줄 주석,해제
	Ctrl+k+f : 자동 정렬.
	Ctrl+D : 동일문자 동시 편집.
	Ctrl+Ship+L : 동일문자 동시 편집
	Ctrl+Alr+위,아래:다중라인 편집
	Ship+Alt+드래그 : 블럭 선택
	
	F12 : 정의문 이동.
	Alt+F12 : 정의문 바로 보기.
	Shift+Alt+F12 : 참조문 전체 찾기.
	Shift+F12 : 참조문 바로 보기.

	Ctrl + H : 바꾸기.
	Ctrl + P : 파일 검색.
	 */
}
