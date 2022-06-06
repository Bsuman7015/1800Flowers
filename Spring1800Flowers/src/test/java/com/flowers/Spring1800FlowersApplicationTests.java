package com.flowers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.model.AccountBean;


@SpringBootTest(classes=Spring1800FlowersApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class Spring1800FlowersApplicationTests {

  private MockMvc mockMvc; 
  @Autowired
  private WebApplicationContext wac;
  @Before
  public void setUp() {
      mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }
	
  protected String mapToJson(Object obj) throws JsonProcessingException {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(obj);
   }
   protected <T> T mapFromJson(String json, Class<T> clazz)
      throws JsonParseException, JsonMappingException, IOException {
      
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.readValue(json, clazz);
   }
   /* 
   @Test
	public void createAccount() throws Exception{
	   String uri = "/api/create";
		List<AccountBean> list = new ArrayList<AccountBean>();
		AccountBean a1= new AccountBean();
		a1.setUserId(1);
		a1.setId(1);
		a1.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		a1.setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
		list.add(a1);
		AccountBean a2= new AccountBean();

		a2.setUserId(2);
		a2.setId(2);
		a2.setTitle("qui est esse");
		a2.setBody("est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla");
		list.add(a2);
		AccountBean a3= new AccountBean();
		a3.setUserId(3);
		a3.setId(3);
		a3.setTitle("ea molestias quasi exercitationem repellat qui ipsa sit aut");
		a3.setBody("et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut");
		list.add(a3);
		AccountBean a4= new AccountBean();
		a4.setUserId(4);
		a4.setId(4);
		a4.setTitle("eum et est occaecati");
		a4.setBody("ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit");
		list.add(a4);
		AccountBean a5= new AccountBean();
		a5.setUserId(2);
		a5.setId(2);
		a5.setTitle("qui est esse");
		a5.setBody("est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla");
		list.add(a5);
		AccountBean a6= new AccountBean();
		a6.setUserId(3);
		a6.setId(3);
		a6.setTitle("ea molestias quasi exercitationem repellat qui ipsa sit aut");
		a6.setBody("et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut");
		list.add(a6);
		AccountBean a7= new AccountBean();
		a7.setUserId(4);
		a7.setId(4);
		a7.setTitle("eum et est occaecati");
		a7.setBody("ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit");
		list.add(a7);
	//	String inputJson = super.mapToJson(list);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content()).andReturn();
			   
			   int status = mvcResult.getResponse().getStatus();
			   assertEquals(201, status);
			   String content = mvcResult.getResponse().getContentAsString();
			   assertEquals(content, "Account is created successfully");
		
	}
   
 
   @Test
   public void getAccountList() throws Exception {
      String uri = "/api/allAccounts";
      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
     System.out.println(mvcResult.getResponse().getContentAsString()); 
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
     
   }
   
   */
   
   
   
   
   
   
   
   
   
   
   
   
   
	
}
