package com.flowers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.controller.AccountController;
import com.flowers.model.AccountBean;
import com.flowers.model.AppCount;
import com.flowers.repository.AccountRepository;
import com.flowers.service.AccountService;



@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	 @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;
	
	 @MockBean
	  AccountRepository accountRepository;
	 
	 @MockBean(name = "accountService1")
	 AccountService accountService;
	 
	 @Test
	  void returnListOfAccounts() throws Exception {
		 List<AccountBean> list = new ArrayList<AccountBean>();
			AccountBean a1= new AccountBean();
			a1.setUserId(1);
			a1.setId(1);
			a1.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
			a1.setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
			list.add(a1);
			AccountBean a2= new AccountBean();

			a2.setUserId(1);
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
	    when(accountRepository.findAll()).thenReturn(list);
	    mockMvc.perform(get("/api/allAccounts"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.size()").value(list.size()))
	        .andDo(print());
	  }
	 @Test
	  void returnUniqueIds() throws Exception {
		 AppCount appCount = new AppCount();
	    List<Integer> accountsIds = new ArrayList<>();
	    accountsIds.add(1);
	    accountsIds.add(2);
	    accountsIds.add(3);
	    accountsIds.add(4);
	    accountsIds.add(5);
	    accountsIds.add(6);
	    accountsIds.add(7);
	    accountsIds.add(8);
	    accountsIds.add(9);
	    accountsIds.add(10);
	    appCount.setUniqueIds(accountsIds);
	    appCount.setCount(accountsIds.size());
	     AppCount uniqueIds = accountService.getUniqueIds();
	       
	    when(uniqueIds).thenReturn(appCount);
	    mockMvc.perform(get("/api/uniqueUserIds"))
	       	        .andDo(print());
	  } 
	 @Test
	  void updateBodyAndTitle() throws Exception {
	    long id = 1L;
	    List<AccountBean> list = new ArrayList<AccountBean>();
		AccountBean a1= new AccountBean();
		a1.setUserId(1);
		a1.setId(1);
		a1.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		a1.setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
		list.add(a1);
	    AccountBean a3= new AccountBean();
		a3.setUserId(3);
		a3.setId(3);
		a3.setTitle("ea molestias quasi exercitationem repellat qui ipsa sit aut");
		a3.setBody("et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut");
		list.add(a3);
		AccountBean a4= new AccountBean();
		a4.setUserId(4);
		a4.setId(4);
		a4.setTitle("1800flowers");
		a4.setBody("1800flowers");
		list.add(a4);
		AccountBean a5= new AccountBean();
		a5.setUserId(2);
		a5.setId(2);
		a5.setTitle("qui est esse");
		a5.setBody("est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla");
		list.add(a5);
		

	    when(accountRepository.findAll()).thenReturn(list);
	    mockMvc.perform( put("/api/updatedTitleAndBody").contentType(MediaType.APPLICATION_JSON))
	      
	    		.andExpect(status().isOk())
		        .andExpect(jsonPath("$.size()").value(list.size()))
		        .andDo(print());
	        
	  }
	  /* 
	  @Test
	  void createAccount() throws Exception {
	  
		  List<AccountBean> list = new ArrayList<AccountBean>();
			AccountBean a1= new AccountBean();
			a1.setUserId(1);
			a1.setId(1);
			a1.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
			a1.setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
			list.add(a1);
			AccountBean a2= new AccountBean();

			a2.setUserId(1);
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
	    mockMvc.perform(post("/api/create").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(a1)))
	        .andDo(print());
	  }
	 */
}
