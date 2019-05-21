package com.sanshao.SpringBootDemo;

import com.sanshao.SpringBootDemo.mail.MailService;
import com.sanshao.SpringBootDemo.model.SimpleUser;
import com.sanshao.SpringBootDemo.model.SimpleUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	@Autowired
	SimpleUserRepository simpleUserRepository;

	@Autowired
	private com.sanshao.SpringBootDemo.mail.MailService MailService;


	@Test
	public void addUsers(){
		for (int i = 1; i < 100; i++) {
			SimpleUser simpleUser = new SimpleUser();
			simpleUser.setName("sanshao_" + i);
			simpleUser.setAge((int) (Math.random() * 100 + 1));
			simpleUserRepository.save(simpleUser);
		}

	}




	@Test
	public void testSimpleMail() throws Exception {
		MailService.sendSimpleMail("qianyinqy@163.com","test simple mail"," hello this is simple mail");
	}

}
