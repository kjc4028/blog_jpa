package com.dev;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class) //테스트시 확장된 junit 클래스를 실행시 선언
@SpringBootTest
public class DevJpa2ApplicationTests {

	@org.junit.jupiter.api.Test //org.junit의 @Test인지 확인 기본 세팅은 jupter 패키지의 TEST
	public void contextLoads() { //void 앞에 public 선언 기본 세팅은 아무것도 없음.
		String a = "asd";
		String b = "asd";
		
		//org.assertj.core.api.Assertions 
		assertThat(a).isNotNull();
		assertThat(a).isEqualTo(b);
		assertThat(a).as("String Compare").isEqualTo(b);
		assertThat(a).contains("a");
		assertThat(a).contains("a").doesNotContain("f");
	}

}
