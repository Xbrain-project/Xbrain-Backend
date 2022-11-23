package com.Xbrain.BackendXbrain;

import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.services.PostService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
//ให้เรียงการ test ตาม class
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class testService {

	@Autowired
	PostService postService;


	// unit test
//	@Test
//	@Order(1) //รันอันแรก
//	void testaddPost() {
//		PostEntity post = postService.addPost(
//			testData
//		);
//
//		// check notnull
//		Assertions.assertNotNull(post);
//
//		// check equal กับค่าที่ส่งไปมั้ย
//		Assertions.assertEquals(testData.username, post.getUsername());
//		Assertions.assertEquals(testData.discription, post.getDescription());
//
//
//	}


	interface testData{
		String username = "junior";
		String discription = "test data";
	}

}
