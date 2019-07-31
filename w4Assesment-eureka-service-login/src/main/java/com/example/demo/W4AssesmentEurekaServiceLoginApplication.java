package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@Controller
public class W4AssesmentEurekaServiceLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(W4AssesmentEurekaServiceLoginApplication.class, args);
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String welcome()
	{
		return "login";
	}
	
	
	
	@RequestMapping(value = "/loginCheck" , method = RequestMethod.POST)
	public String check(@RequestParam String uname, @RequestParam String psd)
	{
		
		String url = "http://LOGIN-CHECK:8061";
		User user = new User();
		user.setId(uname);
		user.setPswd(psd);
		return restTemplate.postForObject(url,user, String.class);

	}

	
}
